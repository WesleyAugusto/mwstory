package br.com.mwstory.model

import org.bson.types.ObjectId

data class Product(
    val _id: ObjectId?,
    val name: String,
    val price: Double,
    val quantity: Int,
    val inventory: Int,
    val category: Category
)