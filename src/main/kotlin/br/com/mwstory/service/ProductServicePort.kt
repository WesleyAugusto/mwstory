package br.com.mwstory.service

import br.com.mwstory.model.Product
import br.com.mwstory.model.ProductEntity

interface ProductServicePort {
    fun getOneProduct(id: String): ProductEntity?
    fun getAllProducts(): List<ProductEntity>
    fun postProduct(requestProduct: Product): ProductEntity
    fun putProduct(requestProduct: Product): ProductEntity
    fun deleteProduct(id: String): ProductEntity?
}