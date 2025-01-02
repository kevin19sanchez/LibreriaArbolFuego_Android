package com.example.libreriaarboldefuegodemo.Model

import com.google.gson.annotations.SerializedName

data class Review (
    @SerializedName("id")
    val id:String,

    @SerializedName("title")
    val title:String,

    @SerializedName("image")
    val description:String,

    @SerializedName("date")
    val publication_date:String,

    @SerializedName("rating")
    val rating: Float,
)