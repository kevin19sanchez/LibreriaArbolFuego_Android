package com.example.libreriaarboldefuegodemo.Model

import com.google.gson.annotations.SerializedName

data class Book (
    @SerializedName("id")
    val id:String,

    @SerializedName("title")
    val title:String,

    @SerializedName("description")
    val description:String,

    @SerializedName("image")
    val coverImageUrl:String, //image

    @SerializedName("rating")
    val rating: Float,
)