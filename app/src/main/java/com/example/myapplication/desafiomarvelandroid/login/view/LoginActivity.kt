package com.example.myapplication.desafiomarvelandroid.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.desafiomarvelandroid.R
import com.example.myapplication.desafiomarvelandroid.home.view.MainActivity
import com.example.myapplication.desafiomarvelandroid.register.view.RegisterActivity
import com.google.android.material.textfield.TextInputEditText

var SEGUIR_L = false
const val ERRO = "CAMPO VAZIO"

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.btnCreateAccount).setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.btnLogin).setOnClickListener {

            val email = findViewById<TextInputEditText>(R.id.emailLogin).text.toString()
            val senha = findViewById<TextInputEditText>(R.id.senhaLogin).text.toString()

            checarEntradas(email, senha)

            if (SEGUIR_L) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                clear()
                SEGUIR_L = false
            }
        }
    }

    private fun checarEntradas(email: String, senha: String) {

        if (email.trim().isEmpty()) {
            findViewById<TextInputEditText>(R.id.emailLogin).error = ERRO
        } else if (senha.trim().isEmpty()) {
            findViewById<TextInputEditText>(R.id.senhaLogin).error = ERRO
        } else SEGUIR_L = true
    }

    private fun clear() {
        findViewById<TextInputEditText>(R.id.emailLogin).text?.clear()
        findViewById<TextInputEditText>(R.id.senhaLogin).text?.clear()
    }
}