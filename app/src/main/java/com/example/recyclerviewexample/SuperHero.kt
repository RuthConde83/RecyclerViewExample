package com.example.recyclerviewexample

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperHero (
    var nombre: String,
    var cover: String,
    var descripcion: String
): Parcelable


