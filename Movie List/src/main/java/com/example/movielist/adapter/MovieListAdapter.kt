package com.example.movielist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.databinding.MovieCardBinding
import com.example.movielist.model.Movie

class MovieListAdapter(var context: Context, var movies:MutableList<Movie>):RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {
    lateinit var binding:MovieCardBinding

    class MyViewHolder(var binding:MovieCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = MovieCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var movie = movies[position]
        holder.binding.tvCategory.text = movie.category
        holder.binding.tvTitle.text = movie.name
        holder.binding.tvDesc.text = movie.desc

        Glide
            .with(context)
            .load(movie.imgUrl)
            .into(holder.binding.imageView)
    }

    fun setItems(movies: MutableList<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

}