package com.example.recyclerviewexample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val superheroes: List<SuperHero> = listOf(
            SuperHero("Spider-man","https://i.pinimg.com/736x/b4/3f/d0/b43fd078caa4fe49d70dce70a34b037a.jpg","Científico, vigilante, profesor, fotógrafo, superhéroe. Fuerza, velocidad, durabilidad, agilidad, sentidos, reflejos, coordinación, equilibrio y resistencia sobrehumanos. Fisiología de la araña: Precognitiva capacidad de sentido arácnido, se aferra a la mayoría de las superficies sólidas y la capacidad de las redes."),
            SuperHero("Nightwing", "https://i.pinimg.com/736x/4c/78/d6/4c78d6a29d6fb66d8330deea73abf39e.jpg", "Es más delgado y menos corpulento que Batman y la lucha contra el crimen le ha dejado marcas en el cuerpo en forma de cicatrices y heridas de bala. Mide 1.78 cm de altura y pesa 79 kg. Sus ojos son de un color azul intenso y su cabello es largo hasta las orejas y negro."),
            SuperHero("Todoroki", "https://i.pinimg.com/736x/2f/ab/7a/2fab7ad190f611a604b2071106e1e905.jpg", "Tiene el pelo largo por encima cuello, en dos colores: blanco en su lado derecho y rojo a en la izquierda, también lleva flequillo. Tiene unos ojos muy llamativos ya que tiene uno de cada manera; el iris de su ojo izquierdo es turquesa, mientras que el derecho es marrón grisáceo.")

        )

        binding.recycler.adapter = SuperHeroAdapter(superheroes) { superhero ->
            navigateTo(superhero)

//            Toast.makeText(this@MainActivity, superhero.nombre, Toast.LENGTH_LONG).show()

       }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun navigateTo(superhero: SuperHero) {

        val intent = Intent(this, DescripcionActivity::class.java)
        intent.putExtra(DescripcionActivity.EXTRA_SUPERHERO, superhero)
        startActivity(intent)
    }

}
