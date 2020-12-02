package com.example.myapplication.desafiomarvelandroid.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.desafiomarvelandroid.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}