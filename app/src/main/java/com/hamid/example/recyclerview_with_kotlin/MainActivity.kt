package com.hamid.example.recyclerview_with_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Memanggil foto pada drawable dan menambahkan judul dan deskripsi untuk gambar yang di panggil dari drawable
class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    //halaman dari activity main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            //List gambar
        val imageList = listOf<Tsukasaanime>(
            Tsukasaanime(
                R.drawable.tsukasa1,
                //judul gambar
                "Tsukoyomi Tsukasa",
                //deskripsi
                "Tsukasa adalah seorang gadis yang masih berusia 16 tahun. Dia merupakan keponakan dari menteri" +
                        " pendidikan. Namun, Tsukasa bukanlah gadis yang materialistis. Ia tiba-tiba kabur dari rumah " +
                        "hanya untuk menikahi Yuzaki Nasa. Keputusan yang mendadak itu begitu mengguncang keluarga Tsukoyomi.."
            ),
            Tsukasaanime(
                R.drawable.mymiku,
                //judul gambar
                "Nakano Miku",
                //deskripsi
                "Nakano Miku adalah saudara perempuan ketiga dari Kembar Lima Nakano , dan salah satu " +
                        "karakter utama dari seri 5-toubun no Hanayome . Dia memiliki kepribadian yang pemalu."
            ),
            Tsukasaanime(
                R.drawable.elaina,
                //judul gambar
                "Elaina",
                //deskripsi
                "Elaina berpetualang melihat dunia dimana dia menemukan banyak hal, " +
                        "mulai dari orang-orang yang dia temui, desa, kota dan kondisi tidak normal yang dia temukan."
            ),
            Tsukasaanime(
                R.drawable.siesta,
                //judul gambar
                "Siesta",
                //deskripsi
                "Siesta adalah seorang pahlawan wanita tituler Detektif Sudah Mati. seri , yang menyebut dirinya Detektif Hebat."
            ),
            Tsukasaanime(
                R.drawable.yuu_otosaka,
                //judul gambar
                "Yuu Otosaka",
                //deskripsi
                "Yuu Otosaka adalah anak yang memiliki kemampuan untuk mengambil alih tubuh orang lain selama 5 detik, " +
                        "berniat untuk menggunakan kekuatannya untuk menjalani kehidupan SMA dengan mudah."
            )
        )
        // memanggil recyclerview dari rv_tsukasa di activity main
        val recyclerView = findViewById<RecyclerView>(R.id.rv_tsukasa)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = animeadapter(this, imageList){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}
