package com.reychellV.appalmacenamiento

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById<EditText>(R.id.editTextNombre)
        val datos = findViewById<EditText>(R.id.editTextDatos)
        val consultar = findViewById<Button>(R.id.buttonGuardar)
        val guardar = findViewById<Button>(R.id.buttonConsultar)
        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)

        guardar.setOnClickListener {
            var editor = preferencias.edit()
            editor.putString(nombre.text.toString(),datos.text.toString())
            editor.commit()
            Toast.makeText(this, "Se registró el contacto",Toast.LENGTH_LONG).show()
            nombre.setText("")
            datos.setText("")
        }

        consultar.setOnClickListener {
            val datosConsultados = preferencias.getString(nombre.text.toString(),"")
            if (datosConsultados != null){
                if (datosConsultados.length == 0){
                    Toast.makeText(this, "No existe el contacto.", Toast.LENGTH_LONG).show()
                }else{
                    datos.setText(datosConsultados)
                }
            }
        }
    }
}