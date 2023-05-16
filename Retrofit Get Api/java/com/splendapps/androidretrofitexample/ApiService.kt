package com.splendapps.androidretrofitexample

import com.splendapps.androidretrofitexample.model.UserListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users?page=2")
    fun getUserList(): Call<UserListResponse>

}