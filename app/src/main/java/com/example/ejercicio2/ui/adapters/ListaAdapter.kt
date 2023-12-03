package com.example.ejercicio2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.databinding.DisenhoListaBinding
import com.example.ejercicio2.model.gaofth

class ListaAdapter(
    private var listas: ArrayList<gaofth>,
    private var elementClick: (list: gaofth)->Unit
): RecyclerView.Adapter<ListaAdapter.ViewHolder>(){

    class ViewHolder(private val binding: DisenhoListaBinding):RecyclerView.ViewHolder(binding.root){
        //Vincular elementos a mostrar
        fun bind(list: gaofth){
            binding.txNombre.text= list.Nombre
            binding.txApellido.text = list.Apellido
            //Imagen
            Glide.with(itemView.context).load(list.UrlImagen).into(binding.imaPersonaje)
        }
    }
//Manda a llamar a la clase viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DisenhoListaBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }
//cantidad de elementos a inflar
    override fun getItemCount(): Int=listas.size
//funcion que los va a vincular
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listas[position])
        holder.itemView.setOnClickListener{
            elementClick(listas[position])
        }
    }
}