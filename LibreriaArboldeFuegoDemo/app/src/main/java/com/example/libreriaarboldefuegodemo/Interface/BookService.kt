package com.example.libreriaarboldefuegodemo.Interface

import com.example.libreriaarboldefuegodemo.Model.Book
import com.example.libreriaarboldefuegodemo.Model.Review
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface BookService {
    @GET("/api/pong")
    fun getBooks(): Call<List<Book>>

    @POST("/api/review")
    fun getReview(): Call<List<Review>>
}