package com.ex.provamobile

import android.os.Parcel
import android.os.Parcelable

data class Bebidas(

    val nome: String,
    val descricao: String,
    val bebidaImg: Int
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(nome)
            parcel.writeString(descricao)
            parcel.writeInt(bebidaImg)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Bebidas> {
            override fun createFromParcel(parcel: Parcel): Bebidas {
                return Bebidas(parcel)
            }

            override fun newArray(size: Int): Array<Bebidas?> {
                return arrayOfNulls(size)
            }
        }
    }