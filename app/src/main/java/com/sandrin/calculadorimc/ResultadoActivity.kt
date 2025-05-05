package com.sandrin.calculadorimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

            val imc = calcularImc(peso, altura)

            val textoExibicao = exibicao(imc)

            textResultado.text = textoExibicao

            configurarImagem(imc)

            }
        }
    }

    private fun calcularImc(p: Double, a: Double): Double {
        val imc = p / (a * a)

        return imc
    }

    private fun exibicao(imc: Double): String {
        val imcFormatado = String.format("%.2f", imc) // formata com 2 casas decimais

        return when {
            imc < 18.5 -> "IMC: $imcFormatado"
            imc in 18.5..24.9 -> "IMC: $imcFormatado"
            imc in 25.0..29.9 -> "IMC: $imcFormatado"
            else -> "IMC: $imcFormatado"

        }
    }
    private fun configurarImagem(imc: Double) {

        if (imc < 18.5) {
            binding.imgResultado.setImageDrawable(ContextCompat.getDrawable(this@ResultadoActivity, R.drawable.baixo))
        } else if (imc in 18.5..24.9) {
            binding.imgResultado.setImageDrawable(ContextCompat.getDrawable(this@ResultadoActivity, R.drawable.medio))
        } else if (imc in 25.0..29.9) {
            binding.imgResultado.setImageDrawable(ContextCompat.getDrawable(this@ResultadoActivity, R.drawable.sobrepeso))
        } else {
            binding.imgResultado.setImageDrawable(ContextCompat.getDrawable(this@ResultadoActivity, R.drawable.obesidade))
        }

    }


}