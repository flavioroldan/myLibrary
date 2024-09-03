package com.example.mylibrary.model.response

sealed class Result (
    val success: Boolean,
    val resultMessage: String? = null,
    val errorMessage: String? = null
)
{
    class Success(message: String?) : Result(success = true, resultMessage = message)

    class Error(errorMessage: String?) : Result(success = false, errorMessage = errorMessage)
}