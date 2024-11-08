package com.ex.provamobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BebidasAdapter (private val bebidas: List<Bebidas>, private val onClick: (Bebidas) -> Unit) :
    RecyclerView.Adapter<BebidasAdapter.EstadoViewHolder>() {

    inner class EstadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bebidaImageView: ImageView = itemView.findViewById(R.id.imageViewBebidas)
        private val nomeTextView: TextView = itemView.findViewById(R.id.textViewNomeBebida)

        fun bind(bebida: Bebidas) {
            bebidaImageView.setImageResource(bebida.bebidaImg)
            nomeTextView.text = bebida.nome

            itemView.setOnClickListener {
                onClick(bebida)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstadoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bebida, parent, false)
        return EstadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EstadoViewHolder, position: Int) {
        holder.bind(bebidas[position])
    }

    override fun getItemCount(): Int = bebidas.size
}
