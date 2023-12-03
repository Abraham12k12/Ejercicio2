package com.example.ejercicio2.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2.databinding.ActivityListaBinding
import com.example.ejercicio2.model.gaofth
import com.example.ejercicio2.network.RetrofitService
import com.example.ejercicio2.network.gaofthAPI
import com.example.ejercicio2.ui.adapters.ListaAdapter
import com.example.ejercicio2.util.Constantes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Lista : AppCompatActivity() {

    private lateinit var binding: ActivityListaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Constantes.Base_URL
        //Constantes.LogTag
        val call=RetrofitService.getRetrofit()
            .create(gaofthAPI::class.java)
            .getgaofth("api/v2/Characters")

        call.enqueue(object: Callback<ArrayList<gaofth>>{
            //Respuesta del lado del servidor
            override fun onResponse(
                call: Call<ArrayList<gaofth>>,
                response: Response<ArrayList<gaofth>>
            ) {
                binding.simboloCarga.visibility= View.INVISIBLE

                Log.d(Constantes.LogTag, "Respuesta del servidor: ${response.toString()}")
                Log.d(Constantes.LogTag, "Datos: ${response.body().toString()}")
//             /* Primera prueba
                val adapterGOFTH=ListaAdapter(response.body()!!){gaofth ->
                    //funcion lamda. Click en cada personaje
                    //Toast.makeText(this@Lista, "Se hizo click en el elemento ${gaofth.Nombre}",Toast.LENGTH_LONG).show()
                    val bundle= bundleOf(
                        "id" to gaofth.id
                    )
                    val intent=Intent(this@Lista, CaracteristicasPersonajes::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }

                binding.RecyView.layoutManager=LinearLayoutManager(this@Lista, RecyclerView.VERTICAL,false)
                binding.RecyView.adapter=adapterGOFTH
//          *///Primera prueba
            }
            //No optiene conexion
            override fun onFailure(call: Call<ArrayList<gaofth>>, t: Throwable) {
                binding.simboloCarga.visibility= View.INVISIBLE
                Toast.makeText(this@Lista, "No hay conexión disponible", Toast.LENGTH_SHORT).show()
            }

        })
    }
}