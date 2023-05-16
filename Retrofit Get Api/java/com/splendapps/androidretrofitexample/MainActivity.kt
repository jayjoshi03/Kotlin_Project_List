package com.splendapps.androidretrofitexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.splendapps.androidretrofitexample.adapter.UserListAdapter
import com.splendapps.androidretrofitexample.databinding.ActivityMainBinding
import com.splendapps.androidretrofitexample.model.User
import com.splendapps.androidretrofitexample.model.UserListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var listAdapter: UserListAdapter
    private var userList = mutableListOf<User>()

    lateinit var retrofit: Retrofit
    lateinit var service: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)

        listAdapter = UserListAdapter(this, userList)
        binding.recyclerItem.layoutManager = LinearLayoutManager(this)
        binding.recyclerItem.adapter = listAdapter

        loadUserList()

    }

    private fun loadUserList() {

        binding.progressBar.visibility = View.VISIBLE

        service.getUserList().enqueue(object : Callback<UserListResponse> {
            override fun onResponse(
                call: Call<UserListResponse>,
                response: Response<UserListResponse>
            ) {
                binding.progressBar.visibility = View.GONE
                // success
                if (response.isSuccessful) {
                    var res = response.body()

                    userList = res!!.userList
                    listAdapter.setItems(userList)
                }
                //  Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<UserListResponse>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
            }

        })

    }
}