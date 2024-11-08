package com.ex.provamobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bebida = listOf(
            Bebidas("Expresso","Um café forte e concentrado feito ao forçar água quente através de café \n" +
                    "moído fino. Base de várias outras bebidas de café.",R.drawable.expresso),
            Bebidas("Cappuccino","Combina espresso com partes iguais de leite vaporizado e espuma de \n" +
                    "leite. Famoso pelo equilíbrio entre sabores ricos e textura cremosa. ",R.drawable.cappucino),
            Bebidas("Latte ","Uma dose de espresso com uma quantidade generosa de leite vaporizado \n" +
                    "e uma pequena camada de espuma por cima. Suave e levemente \n" +
                    "adocicado. ",R.drawable.latte),
            Bebidas("Americano","Espresso diluído com água quente, resultando em um café mais suave e \n" +
                    "menos intenso. Popular entre quem gosta de sabores menos \n" +
                    "concentrados. ",R.drawable.americano),
            Bebidas("Mocha","Mistura de espresso com leite vaporizado e uma dose de chocolate. \n" +
                    "Geralmente coberto com chantilly e popular entre os amantes de \n" +
                    "chocolate.",R.drawable.mocha),
            Bebidas("Macchiato","Espresso “manchado” com um pouco de espuma de leite, acentuando o \n" +
                    "sabor forte do café com apenas um toque de suavidade. ",R.drawable.macchiato),
            Bebidas("Flat White","Similar ao cappuccino, mas com menos espuma e uma proporção maior \n" +
                    "de leite. De origem australiana, tem sabor intenso e textura sedosa. ",R.drawable.flatwhite),
            Bebidas("Ristretto ","Uma dose de espresso mais concentrada e curta, com sabor mais denso \n" +
                    "e encorpado. Ideal para quem gosta de café intenso. ",R.drawable.ristreto),
            Bebidas("Affogato ","Uma sobremesa italiana que combina espresso quente sobre uma bola de \n" +
                    "sorvete de baunilha. Uma deliciosa fusão de quente e frio. ",R.drawable.affogato),
            Bebidas("Cold Brew ","Café preparado com infusão em água fria por 12-24 horas, resultando em \n" +
                    "um sabor suave e menos ácido. Servido gelado. ",R.drawable.coldbrew),

        )
        val recyclerView: RecyclerView = findViewById(R.id.lista)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BebidasAdapter(bebida) { estado ->
            val intent = Intent(this, DetalhesBebida::class.java)
            intent.putExtra("estado", estado)
            startActivity(intent)
        }
    }
}