package com.example.ejercicio2.model

import com.google.gson.annotations.SerializedName

data class Personajes(
    @SerializedName("fullName")  val NombreCompleto: String,
    @SerializedName("title") val titulo: String,
    @SerializedName("family") val Familia: String,
    @SerializedName("image") val NameImagen: String,
    @SerializedName("imageUrl") val UrlImagen: String,
)
