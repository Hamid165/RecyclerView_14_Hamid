package com.hamid.example.recyclerview_with_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// mengambil data class dari Tsukasaanime yang sudah di buat
class animeadapter (
        private val context: Context, private val images: List<Tsukasaanime>, val listener: (Tsukasaanime) -> Unit
) : RecyclerView.Adapter<animeadapter.ImageViewHolder>() {
        class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                // memanggil id dari foto,judul anime dan deskripsi dari item_anime
                val imageSrc = view.findViewById<ImageView>(R.id.img_item_photo)
                val title = view.findViewById<TextView>(R.id.tv_item_name)
                val Desc = view.findViewById<TextView>(R.id.tv_item_description)
                //memanggil data class foto judul dan deskripsi dari tsukasa anime
                fun bindView(image: Tsukasaanime, listener: (Tsukasaanime) -> Unit) {
                        imageSrc.setImageResource(image.imageSrc)
                        title.text = image.imageTitle
                        Desc.text = image.imageDesc
                        itemView.setOnClickListener {listener(image) }
                }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
                ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_anime, parent, false))
        override fun getItemCount(): Int = images.size
        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
                holder.bindView(images[position], listener)
        }
}