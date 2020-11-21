package com.example.onlinebus

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Bus(
    val busImage: Int,
    val arrivalPlace: String,
    val destinationPlace: String,
    val places: Int,
    val freePlaces: Int,
    val arrivalTime: String,
    val destinationTime: String,
    val duration: Int,
    val busMark: String,
    val busMadeYear: Int,
    val busNumber: String
) : Parcelable {}