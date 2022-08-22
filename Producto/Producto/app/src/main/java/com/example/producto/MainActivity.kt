package com.example.producto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ETproducto_name= findViewById <EditText>(R.id.ETproducto_name)
        val ETproducto_categoria= findViewById <EditText>(R.id.ETproducto_categoria)
        val ETproducto_codigo= findViewById <EditText>(R.id.ETproducto_codigo)
        val ETproducto_precio= findViewById <EditText>(R.id.ETproducto_precio)
        val ETproducto_stock= findViewById <EditText>(R.id.ETproducto_stock)
        val ETproducto_estado= findViewById <EditText>(R.id.ETproducto_estado)
        val Boton = findViewById<Button>(R.id.Boton)

        Boton.setOnClickListener{
            Log.d("MainActivity", "Button clicked")
        }
    }
}