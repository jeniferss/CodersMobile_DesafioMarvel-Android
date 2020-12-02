package com.example.myapplication.desafiomarvelandroid.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myapplication.desafiomarvelandroid.R
import com.example.myapplication.desafiomarvelandroid.home.view.MainActivity
import com.google.android.material.textfield.TextInputEditText

const val ERRO = "CAMPO VAZIO"
var SEGUIR = false

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<Button>(R.id.btnSave).setOnClickListener {

            val nome = findViewById<TextInputEditText>(R.id.name).text.toString()
            val email = findViewById<TextInputEditText>(R.id.emailResgister).text.toString()
            val senha = findViewById<TextInputEditText>(R.id.senhaRegister).text.toString()

            checarEntradas(nome, email, senha)

            if (SEGUIR == true) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                clear()
                SEGUIR = false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun checarEntradas(nome: String, email: String, senha: String) {
        if (nome.trim().isEmpty()) {
            findViewById<TextInputEditText>(R.id.name).error = ERRO
        } else if (email.trim().isEmpty()) {
            findViewById<TextInputEditText>(R.id.emailResgister).error = ERRO
        } else if (senha.trim().isEmpty()) {
            findViewById<TextInputEditText>(R.id.senhaRegister).error = ERRO
        } else SEGUIR = true
    }

    fun clear() {
        findViewById<TextInputEditText>(R.id.name).text?.clear()
        findViewById<TextInputEditText>(R.id.emailResgister).text?.clear()
        findViewById<TextInputEditText>(R.id.senhaRegister).text?.clear()
    }
}