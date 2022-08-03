package com.nosense.shopor.network

import com.nosense.shopor.model.request.register.RegisterRequest
import com.nosense.shopor.model.response.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
}