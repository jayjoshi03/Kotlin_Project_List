package com.example.movielist.retrofit

import com.example.movielist.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("movielist.json")
    fun getMovieList(): Call<MutableList<Movie>>
}