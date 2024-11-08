package com.ex.provamobile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesBebida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_bebida)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bebida = intent.getParcelableExtra<Bebidas>("bebida")

        if (bebida != null) {
            val bebidaImageView: ImageView = findViewById(R.id.imageViewBebidasDetalhadas)
            val nomeTextView: TextView = findViewById(R.id.textViewNomeBebidasDetalhe)
            val descricaoTextView: TextView = findViewById(R.id.textViewDescricao)


            bebidaImageView.setImageResource(bebida.bebida)
            nomeTextView.text = bebida.nome
            descricaoTextView.text = "Descrição: ${bebida.descricao}"

        }
    }
}