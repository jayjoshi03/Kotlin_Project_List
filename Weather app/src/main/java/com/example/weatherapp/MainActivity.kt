package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var retrofit:Retrofit
    private lateinit var service:ApiService
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)

        loadWeather()
    }

    private fun loadWeather() {

        service.getWeatherList("surat","dae6b4da232a90488183ab5d3f2cb328").enqueue(object: Callback<WeatherResponse>{
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                    var res = response.body()!!
                    binding.tvCity.text = res!!.name
                    var i = res.main.temp.toFloat()
                    var j = i - 273.15
                binding.tvTemp.text = j.toInt().toString()
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Connection Fail", Toast.LENGTH_SHORT).show()
            }

        })

    }
}