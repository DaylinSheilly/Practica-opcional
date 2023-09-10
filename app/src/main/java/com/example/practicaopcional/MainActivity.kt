package com.example.practicaopcional

import com.example.practicaopcional.databinding.ActivityMainBinding

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(R.layout.activity_main)
        toast()
        boton()
    }

    private fun toast(){
        Toast.makeText(this,"Aprobó/No aprobó", Toast.LENGTH_SHORT).show()
    }

    private fun boton(){
        binding.btnCalcular.setOnClickListener{

            val nombre_persona = binding.etPersona.text
            val nombre_curso = binding.etCurso.text
            val nota_1 = binding.etNota1.text
            val nota_2 = binding.etNota2.text

            val camposLlenos= nombre_persona.isNotEmpty() && nombre_curso.isNotEmpty() && nota_1.isNotEmpty() && nota_2.isNotEmpty()

            binding.btnCalcular.isEnabled = camposLlenos

            Toast.makeText(this,"click", Toast.LENGTH_LONG).show()

        }
    }




}