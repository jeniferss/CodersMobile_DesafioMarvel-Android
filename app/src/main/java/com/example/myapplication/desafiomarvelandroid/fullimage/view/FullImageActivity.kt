package com.example.myapplication.desafiomarvelandroid.fullimage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.myapplication.desafiomarvelandroid.R
import com.squareup.picasso.Picasso

class FullImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

        val imgFull = findViewById<ImageView>(R.id.imgFull)
        val imgFullSet = intent.getStringExtra("IMAGEM_FULL")

        Picasso.get()
            .load(imgFullSet)
            .into(imgFull)

        findViewById<ImageView>(R.id.btnClose).setOnClickListener {
            finish()
        }
    }
}