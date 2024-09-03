package com.example.mylibrary.network

import com.example.mylibrary.constants.EndPointsConstants.BASE_URL
import com.example.mylibrary.constants.EndPointsConstants.SAVE_STRING
import com.example.mylibrary.model.request.SaveStringRequestData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPI {
    @POST("$BASE_URL/$SAVE_STRING")
    suspend fun saveString(@Body saveStringRequestDate: SaveStringRequestData): Response<String>
}