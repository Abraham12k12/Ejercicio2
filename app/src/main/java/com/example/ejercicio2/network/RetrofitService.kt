package com.example.ejercicio2.network

import com.example.ejercicio2.util.Constantes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService{
    private var INSTANCE: Retrofit?=null

    fun getRetrofit():Retrofit= INSTANCE ?: synchronized(this){
        val instance=Retrofit.Builder()
            .baseUrl(Constantes.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        INSTANCE=instance
        instance
    }
}