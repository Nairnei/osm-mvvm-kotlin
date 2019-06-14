package com.nanx.osm_kotlin_mvvm.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OsmService {

    companion object {
        private var baseUrl = "https://nominatim.openstreetmap.org"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
