package com.example.test_pizza

import retrofit2.http.GET
import retrofit2.http.Path

interface CheckApiInterface {
    @GET("products/{id}")
    suspend fun getPizzaById(@Path("id") id: Int): CheckApi
}