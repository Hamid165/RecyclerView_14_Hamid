package com.hamid.example.recyclerview_with_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

//Memanggil activity_detail yang ketika foto di klik maka akan menampilkan detail dari foto tersebut
//di detail activity ini memanggil foto, judul foto dan deskripsi dari foto
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val image = intent.getParcelableExtra<Tsukasaanime>(MainActivity.INTENT_PARCELABLE)
        //memanggil foto nama foto dan deskripsi dari activity detail
        val imgSrc = findViewById<ImageView>(R.id.img_item_tsukasa)
        val imgTitle = findViewById<TextView>(R.id.tv_item_name)
        val imgDesc = findViewById<TextView>(R.id.tv_item_description)

        if (image != null) {
            imgSrc.setImageResource(image.imageSrc)
            imgTitle.text = image.imageTitle
            imgDesc.text = image.imageDesc
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
