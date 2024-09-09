package com.sandrin.calculadorimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCalcular = findViewById(R.id.btn_calcular)

        btnCalcular.setOnClickListener {

            val intent = Intent(this, ResultadoActivity::class.java)

            startActivity( intent )


        }


    }
}