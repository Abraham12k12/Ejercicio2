package com.example.ejercicio2.network

import com.example.ejercicio2.model.Personajes
import com.example.ejercicio2.model.gaofth
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface gaofthAPI {
    @GET //("api/v2/Characters")
    fun getgaofth(
        @Url url: String?
    ): Call<ArrayList<gaofth>> //

    @GET("api/v2/Characters/{id}")
    fun getgaofthPerson(                      //getgaofthPerson("41253")
        @Path("id") id:String?
    ): Call<Personajes>

}