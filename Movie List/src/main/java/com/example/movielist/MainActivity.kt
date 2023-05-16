package com.example.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movielist.adapter.MovieListAdapter
import com.example.movielist.databinding.ActivityMainBinding
import com.example.movielist.model.Movie
import com.example.movielist.retrofit.ApiClient
import com.example.movielist.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var listAdapter:MovieListAdapter
    private lateinit var binding: ActivityMainBinding
    var movieList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loading.visibility = View.VISIBLE

        listAdapter = MovieListAdapter(this, movieList)
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        binding.recyclerView.adapter = listAdapter

        loadMovieList()

    }

    private fun loadMovieList() {

        ApiClient.init().getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                if (response.isSuccessful){
                    binding.loading.visibility = View.GONE
                    var res = response.body()

                    movieList = res!!
                    listAdapter.setItems(movieList)
                }
            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                Toast.makeText(applicationContext, "Connection Failed!", Toast.LENGTH_SHORT).show()
            }
        })


    }
}

