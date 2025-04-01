package com.sandrin.calculadorimc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        inicializarComponentesInterface()

        val bundle = intent.extras

        if( bundle != null ){

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado: $peso Kg"
            textAltura.text = "Altura informada: $altura m"

            val resultado = calcularImc(peso, altura)

            textResultado.text = resultado

        }

    }
    private fun inicializarComponentesInterface(){

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)

    }
    private fun calcularImc(p: Double, a: Double): String {
        val imc = p / (a * a)
        val imcFormatado = String.format("%.2f", imc) // Formata com 2 casas decimais

        return when {
            imc < 18.5 -> "IMC: $imcFormatado \n Situação -> Baixo"
            imc in 18.5..24.9 -> "IMC: $imcFormatado \n Situação -> Normal"
            imc in 25.0..29.9 -> "IMC: $imcFormatado \n Situação -> Sobrepeso"
            else -> "IMC: $imcFormatado \n Situação -> Obeso"
        }
    }

}