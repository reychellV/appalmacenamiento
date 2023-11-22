package com.reychellV.appalmacenamiento

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

import java.io.OutputStreamWriter

class MainActivityNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_notas)


    val notas = findViewById<EditText>(R.id.editTextNotas)
    val botonGuardar = findViewById<Button>(R.id.buttonGuardarNotas)

    if(fileList().contains("notas.txt")){
        try {
            val archivo = InputStreamReader(openFileInput("notas.txt"))
            val lectura = BufferedReader(archivo)
            var linea = lectura.readLine()
            val lecturaTotal = StringBuilder()
            while (linea != null){
                lecturaTotal.append(linea + "\n")
                linea= lectura.readLine()
            }
            lectura.close()
            archivo.close()
            notas.setText(lecturaTotal)

        }catch (e: IOException){
            Toast.makeText(this, "¡Error $e!", Toast.LENGTH_LONG).show()
        }
    }
    botonGuardar.setOnClickListener {
        val archivo = OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE))
    }
}  }