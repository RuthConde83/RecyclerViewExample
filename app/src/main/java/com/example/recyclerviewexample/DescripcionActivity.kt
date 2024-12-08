package com.example.recyclerviewexample

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.recyclerviewexample.databinding.ActivityDescripcionBinding

class DescripcionActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_SUPERHERO = "DespcripcionActivity:superhero"
    }

    private lateinit var binding: ActivityDescripcionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDescripcionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val superhero = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getParcelableExtra(EXTRA_SUPERHERO, SuperHero::class.java)
        }else{
            intent.getParcelableExtra<SuperHero>(EXTRA_SUPERHERO)
        }
        if(superhero != null){
           var nombre = superhero.nombre
            Glide.with(this).load(superhero.cover).into(binding.imageViewDescripcion)
            binding.textViewDescripcion.text = superhero.descripcion
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}