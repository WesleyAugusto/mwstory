package br.com.mwstory.repository

import br.com.mwstory.model.ProductEntity

interface ProductRepositoryPort {
    fun findAllProductsRepository(): List<ProductEntity>
    fun insertProductRepository(productEntity: ProductEntity): ProductEntity
}