package com.example.warungwartegtegal.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    val name: String,
    val price: String,
    val imageRes: Int,
    var isSelected: Boolean = false // Assuming you have this for selection
) : Parcelable
    