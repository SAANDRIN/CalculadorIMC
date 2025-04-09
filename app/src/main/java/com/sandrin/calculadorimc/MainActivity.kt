package com.sandrin.calculadorimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sandrin.calculadorimc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, ResultadoActivity::class.java)

        with( binding ){

        btnCalcular.setOnClickListener {

            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()

            val inputUsuario = verificarInputUsuario(peso, altura)

            if( inputUsuario == true ){

                intent.putExtra("peso", peso.toDouble() )
                intent.putExtra("altura", altura.toDouble() )

                startActivity( intent )

                }
            }
        }
    }

    private fun verificarInputUsuario(p: String, a: String): Boolean{

        with( binding ){

    textInputPeso.error = ""
    textInputAltura.error = ""


        val verificacao =
            if(p.isEmpty()){
            textInputPeso.error = "Digite o Peso"
            false
        } else if(a.isEmpty()){
            textInputAltura.error = "Digite o Peso"
            false
        } else {
            true
        }
        return verificacao
        }
    }
}