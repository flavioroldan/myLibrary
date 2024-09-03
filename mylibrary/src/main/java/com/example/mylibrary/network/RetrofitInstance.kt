package com.example.mylibrary.network
import com.example.mylibrary.constants.EndPointsConstants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    fun provideRetrofitApi(): RetrofitAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttClient())
            .build()
            .create(RetrofitAPI::class.java)
    }

    private fun getOkHttClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor())
            .build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        return  HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}