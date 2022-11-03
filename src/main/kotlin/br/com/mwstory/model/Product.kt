package br.com.mwstory.model

data class Product(
    val id: String?,
    val name: String,
    val price: Double,
    val quantity: Int,
    val inventory: Int,
    val category: Category
)