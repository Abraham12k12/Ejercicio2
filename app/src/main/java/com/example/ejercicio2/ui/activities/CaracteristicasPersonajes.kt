///* primera prueba
package com.example.ejercicio2.ui.activities

import android.app.sdksandbox.RequestSurfacePackageException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.versionedparcelable.R
import com.bumptech.glide.Glide
import com.example.ejercicio2.databinding.ActivityCaracteristicasPersonajesBinding
import com.example.ejercicio2.model.Personajes
import com.example.ejercicio2.network.RetrofitService
import com.example.ejercicio2.network.gaofthAPI
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class CaracteristicasPersonajes : AppCompatActivity() {

    private lateinit var binding: ActivityCaracteristicasPersonajesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCaracteristicasPersonajesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle=intent.extras
        val id=bundle?.getString("id", "0")

        val call=RetrofitService.getRetrofit()
            .create(gaofthAPI::class.java)
            .getgaofthPerson(id)

        call.enqueue(object: Callback<Personajes>{ //Personajes
            override  fun onResponse(call:Call<Personajes>, response: Response<Personajes>){
                binding.logoCarga.visibility = View.INVISIBLE
                /////////Que mostrar
                binding.tvtitle.text=response.body()?.titulo
                binding.tvFullName.text=response.body()?.NombreCompleto
                Glide.with(this@CaracteristicasPersonajes).load(response.body()?.UrlImagen).into(binding.ivPersonaje)
                //menu
                //Glide.with(this@CaracteristicasPersonajes).load().into(binding.ivPersonaje)
                val comparar=response.body()?.NombreCompleto
                if (comparar?.contains("Arryn")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.arryn)
                }
                else if(comparar?.contains("Baratheon")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.baratheon)
                }
                else if(comparar?.contains("Greyjoy")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.greyjoy)
                }
                else if(comparar?.contains("Lannister")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.lannister)
                }
                else if(comparar?.contains("Martell")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.martell)
                }
                else if(comparar?.contains("Mormont")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.mormont)
                }
                else if(comparar?.contains("Stark")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.stark)
                }
                else if(comparar?.contains("Targaryen")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.targaryen)
                }
                else if(comparar?.contains("Tully")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.tully)
                }
                else if(comparar?.contains("Tyrell")==true){
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.tyrell)
                }
                else{
                    binding.ivEscudo.setImageResource(com.example.ejercicio2.R.drawable.desconocido)
                }
            }
            override fun onFailure(call:Call<Personajes>, t: Throwable){
                binding.logoCarga.visibility=View.INVISIBLE
                Toast.makeText(this@CaracteristicasPersonajes, "No hay conexion", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
//*///Primera prueba