package com.example.rusconsignkotlin

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("accepted-barangs")
    fun getAcceptedBarangs(): Call<ModelBarang>
}