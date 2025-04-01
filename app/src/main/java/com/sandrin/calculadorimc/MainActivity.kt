package com.sandrin.calculadorimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    private lateinit var txtInputPeso: TextInputLayout
    private lateinit var txtInputAltura: TextInputLayout

    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText

    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarComponentesInterface()

        btnCalcular.setOnClickListener {

            val intent = Intent(this, ResultadoActivity::class.java)

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
    private fun inicializarComponentesInterface(){

        txtInputPeso = findViewById(R.id.textInputPeso)
        txtInputAltura = findViewById(R.id.textInputAltura)

        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)

        btnCalcular = findViewById(R.id.btnCalcular)
    }
    private fun verificarInputUsuario(p: String, a: String): Boolean{

    txtInputPeso.error = ""
    txtInputAltura.error = ""


        val verificacao =
            if(p.isEmpty()){
            txtInputPeso.error = "Digite o Peso"
            false
        } else if(a.isEmpty()){
            txtInputAltura.error = "Digite o Peso"
            false
        } else {
            true
        }
        return verificacao
    }
}