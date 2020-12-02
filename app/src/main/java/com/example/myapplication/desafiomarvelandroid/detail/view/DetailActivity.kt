package com.example.myapplication.desafiomarvelandroid.detail.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.desafiomarvelandroid.fullimage.view.FullImageActivity
import com.example.myapplication.desafiomarvelandroid.R
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nome = intent.getStringExtra("NOME")
        val descricao = intent.getStringExtra("DESCRICAO")
        val imagem = intent.getStringExtra("IMAGE")
        val qtdPages = intent.getIntExtra("QTD_PAGINAS", 0)
        val price = intent.getFloatExtra("PRICE", 0F)
        val date = intent.getStringExtra("DATE")

        findViewById<TextView>(R.id.txtTitle).text = nome
        findViewById<TextView>(R.id.txtDescricao).text = descricao
        findViewById<TextView>(R.id.txtQtdPages).text = qtdPages.toString()
        findViewById<TextView>(R.id.txtData).text = date
        findViewById<TextView>(R.id.txtPrice).text = price.toString()

        Picasso.get()
            .load(imagem)
            .into(findViewById<ImageView>(R.id.imgComicMini))

        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        findViewById<ImageView>(R.id.imgComicMini).setOnClickListener {
            val intent = Intent(this, FullImageActivity::class.java)
            intent.putExtra("IMAGEM_FULL", imagem)
            startActivity(intent)
        }

    }
}