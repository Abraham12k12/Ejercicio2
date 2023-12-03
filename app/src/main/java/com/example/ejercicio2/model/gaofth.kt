package com.example.ejercicio2.model

import com.google.gson.annotations.SerializedName

data class gaofth(
    @SerializedName("id")  val id: String?,

    @SerializedName("firstName") val Nombre: String,

    @SerializedName("lastName") val Apellido: String,
    /*
    @SerializedName("fullName")  val NombreCompleto: String,
    @SerializedName("title")  val Serie: String,
    @SerializedName("family")  val Familia: String,
    @SerializedName("image")  val NameImagen: String,*/
    @SerializedName("imageUrl") val UrlImagen: String,
)
