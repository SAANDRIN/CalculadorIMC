package com.sandrin.calculadorimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sandrin.calculadorimc.databinding.ActivityResultadoBinding


class ResultadoActivity : AppCompatActivity() {

    private val binding: ActivityResultadoBinding by lazy {
        ActivityResultadoBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        val bundle = intent.extras

        with( binding ) {

        if( bundle != null ){

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado: $peso Kg"
            textAltura.text = "Altura informada: $altura m"

            val resultado = calcularImc(peso, altura)

            textResultado.text = resultado

            }
        }
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