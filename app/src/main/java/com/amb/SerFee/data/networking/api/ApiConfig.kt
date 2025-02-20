package com.amb.SerFee.data.networking.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Boolean

class ApiConfig {
    companion object {
        val BASE_URL ="http://192.168.1.113:8000"
        val DEBUG = Boolean.parseBoolean("true")
        fun getApiClient(): ApiService {
            val loggingInterceptor = if (DEBUG) {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}





//https://serfee-project.as.r.appspot.com/  http://192.168.1.113:8000

//"https://story-api.dicoding.dev/v1/"