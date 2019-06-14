package com.nanx.osm_kotlin_mvvm.service

import com.nanx.osm_kotlin_mvvm.model.Details
import com.nanx.osm_kotlin_mvvm.model.Reverse
import com.nanx.osm_kotlin_mvvm.model.Search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface OsmApi {

    @GET("/search?")
    fun getSearch(
        @Query("q") params: String?,
        @Query("format") format: String?
    ): Call<Search>

    @GET("/details?")
    fun getDetail(
        @Query("osmtype") osmType: String?,
        @Query("osmid") osmid: Int?,
        @Query("format") format: String?
    ): Call<Details>


    @GET("reverse?")
    fun getReverse(
        @Query("lat") lat: Double?,
        @Query("lon") lon: Double?,
        @Query("format") format: String
    ): Call<Reverse>

}
