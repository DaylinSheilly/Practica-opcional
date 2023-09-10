package com.example.practicaopcional

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.example.practicaopcional.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupTextWatchers()
        setupButton()
        binding.btnCalcular.isEnabled = false
        binding.btnCalcular.setBackgroundColor(Color.GRAY)
    }

    private fun setupTextWatchers() {
        binding.etPersona.addTextChangedListener { nombre ->
            val nombreText = nombre.toString().trim()
            updateButtonState()
        }

        binding.etCurso.addTextChangedListener { curso ->
            val cursoText = curso.toString().trim()
            updateButtonState()
        }

        binding.etNota1.addTextChangedListener { nota1 ->
            val nota1Text = nota1.toString().trim()
            updateButtonState()
        }

        binding.etNota2.addTextChangedListener { nota2 ->
            val nota2Text = nota2.toString().trim()
            updateButtonState()
        }
    }
    private fun updateButtonState() {
        val nombre = binding.etPersona.text.toString().trim()
        val curso = binding.etCurso.text.toString().trim()
        val nota1 = binding.etNota1.text.toString().trim()
        val nota2 = binding.etNota2.text.toString().trim()

        val enableButton = nombre.isNotEmpty() && curso.isNotEmpty() && nota1.isNotEmpty() && nota2.isNotEmpty()
        binding.btnCalcular.isEnabled = enableButton

        if (enableButton) {
            binding.btnCalcular.setBackgroundColor(0xFF6750A3.toInt())
        } else {
            binding.btnCalcular.setBackgroundColor(Color.GRAY)
        }
    }

    private fun setupButton() {
        binding.btnCalcular.setOnClickListener {
            val nombre = binding.etPersona.text.toString().trim()
            val curso = binding.etCurso.text.toString().trim()
            val nota1Text = binding.etNota1.text.toString().trim()
            val nota2Text = binding.etNota2.text.toString().trim()
            val nota1 = nota1Text.toDouble()
            val nota2 = nota2Text.toDouble()
            var promedio = (nota1 + nota2) / 2

            if(binding.cbCheckbox.isChecked){
                promedio -= 0.5 // Restar 0.5 si el CheckBox está marcado
            }

            //Se verifica si apueba o no de acuerdo al promedio
            if (promedio >= 3) {
                Toast.makeText(this, "Aprobó", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Reprobó", Toast.LENGTH_LONG).show()
            }

            // Muestra los datos ingresados en el TextView y agrega un salto de línea
            val resultadoAnterior = binding.resultados.text.toString()
            val nuevoResultado = resultadoAnterior +
                    "Nombre: $nombre\n" +
                    "Curso: $curso\n" +
                    "Nota1: $nota1\n" +
                    "Nota2: $nota2\n" +
                    "Nota Final: $promedio\n\n"

            binding.resultados.text = nuevoResultado

            //Limpia los campos de entrada después de agregar la información
            binding.etPersona.text.clear()
            binding.etCurso.text.clear()
            binding.etNota1.text.clear()
            binding.etNota2.text.clear()
        }
    }


}