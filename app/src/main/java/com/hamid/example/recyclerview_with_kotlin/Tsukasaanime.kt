package com.hamid.example.recyclerview_with_kotlin

import android.os.Parcel
import android.os.Parcelable

// membuat data class dengan value gambar nama dan deskripsi dari anime tersebut
data class Tsukasaanime(val imageSrc: Int, val imageTitle: String?, val imageDesc: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageSrc)
        parcel.writeString(imageTitle)
        parcel.writeString(imageDesc)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Tsukasaanime> {
        override fun createFromParcel(parcel: Parcel): Tsukasaanime {
            return Tsukasaanime(parcel)
        }
        override fun newArray(size: Int): Array<Tsukasaanime?> {
            return arrayOfNulls(size)
        }
    }
}