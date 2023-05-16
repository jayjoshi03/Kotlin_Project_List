package com.example.weatherapp.retrofit

import com.example.weatherapp.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getWeatherList(@Query("q") city: String,
                       @Query("appid") appid: String) : Call<WeatherResponse>
}