package com.nanx.osm_kotlin_mvvm.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nanx.osm_kotlin_mvvm.model.Details
import com.nanx.osm_kotlin_mvvm.model.Reverse
import com.nanx.osm_kotlin_mvvm.model.Search
import com.nanx.osm_kotlin_mvvm.service.OsmApi
import com.nanx.osm_kotlin_mvvm.service.OsmService.Companion.getRetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivityViewModel : ViewModel() {

    private var mRepo: Retrofit? = null
    private val responseSearch = MutableLiveData<Search?>()
    private val responseDetails = MutableLiveData<Details?>()
    private val responseReverse = MutableLiveData<Reverse?>()
    private val error = MutableLiveData<String?>()

    fun init() {
        mRepo = getRetrofitInstance()
    }

    fun search(location: String?) {
        val endpoint = mRepo?.create(OsmApi::class.java)
        val request = endpoint?.getSearch(location, "geojson")

        request?.enqueue(object : Callback<Search> {
            override fun onFailure(call: Call<Search>, t: Throwable) {
                error.value = t.message
            }

            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                responseSearch.value = response.body()
            }

        })
    }

    fun details(osmtype: String?, osmid: Int?) {
        val endpoint = mRepo?.create(OsmApi::class.java)
        val request = endpoint?.getDetail(osmtype, osmid, "json")

        request?.enqueue(object : Callback<Details> {
            override fun onFailure(call: Call<Details>, t: Throwable) {
                error.value = t.message
            }

            override fun onResponse(call: Call<Details>, response: Response<Details>) {
                responseDetails.value = response.body()
            }
        })
    }

    fun reverse(lat: Double?, lon: Double?) {
        val endpoint = mRepo?.create(OsmApi::class.java)
        val request = endpoint?.getReverse(lat, lon, "jsonv2")

        request?.enqueue(object : Callback<Reverse> {
            override fun onFailure(call: Call<Reverse>, t: Throwable) {
                error.value = t.message
            }

            override fun onResponse(call: Call<Reverse>, response: Response<Reverse>) {
                responseReverse.value = response.body()
            }
        })
    }

    fun getReverse(): MutableLiveData<Reverse?> {
        return responseReverse
    }

    fun getSearch(): MutableLiveData<Search?> {
        return responseSearch
    }

    fun getDetails(): MutableLiveData<Details?> {
        return responseDetails
    }

    fun getError(): MutableLiveData<String?> {
        return error
    }


}


