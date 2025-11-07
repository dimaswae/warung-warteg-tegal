package com.example.warungwartegtegal.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderModel(
    val name: String,
    val price: Int,
    val quantity: Int
) : Parcelable
