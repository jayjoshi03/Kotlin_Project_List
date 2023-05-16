package com.example.movielist.model

import com.google.gson.annotations.SerializedName

data class Movie(
    var category: String,
    @SerializedName("imageUrl")
    var imgUrl: String,
    var name: String,
    var desc: String
)
