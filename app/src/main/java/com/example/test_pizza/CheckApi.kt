package com.example.test_pizza

data class CheckApi (
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val image: List<String>)

