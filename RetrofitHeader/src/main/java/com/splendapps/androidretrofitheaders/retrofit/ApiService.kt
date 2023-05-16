package com.splendapps.androidretrofitheaders.retrofit

import com.splendapps.androidretrofitheaders.model.Country
import com.splendapps.androidretrofitheaders.model.State
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path

interface ApiService {

    @GET("countries")
    fun getCountry(
        @HeaderMap headers: Map<String, String>
    ): Call<List<Country>>

    @GET("states/{country}")
    fun getState(
        @HeaderMap headers: Map<String, String>,
        @Path("country") countryName: String
    ): Call<List<State>>

    fun getCity()

}