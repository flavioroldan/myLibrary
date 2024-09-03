package com.example.mylibrary.model

import com.example.mylibrary.model.request.SaveStringRequestData
import com.example.mylibrary.model.response.Result
import com.example.mylibrary.network.RetrofitInstance.provideRetrofitApi

object Service {
    suspend fun saveString(saveStringRequestData: SaveStringRequestData): Result {
        val api = provideRetrofitApi()
        try {
            val result = api.saveString(saveStringRequestData)
            return if (result.isSuccessful) {
                Result.Success(message = result.body())
            } else {
                Result.Error(errorMessage = result.errorBody()?.string())
            }
        } catch (e: Exception) {
            return Result.Error(errorMessage = e.message)
        }
    }
}