package com.example.warungwartegtegal.model

import java.io.Serializable

data class OrderModel(
    val name: String,
    val price: Int,
    var quantity: Int
) : Serializable
