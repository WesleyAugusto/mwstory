package br.com.mwstory.repository

import br.com.mwstory.model.Product
import br.com.mwstory.model.ProductEntity

interface ProductRepositoryPort {
    fun getOneProductsRepository(id: String): ProductEntity?
    fun findAllProductsRepository(): List<ProductEntity>
    fun insertProductRepository(productEntity: ProductEntity): ProductEntity
    fun putProduct(requestProduct: Product): ProductEntity
    fun deleteProduct(id: String): ProductEntity?
}