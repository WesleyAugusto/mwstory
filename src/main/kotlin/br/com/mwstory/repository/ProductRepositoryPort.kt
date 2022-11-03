package br.com.mwstory.repository

import br.com.mwstory.model.ProductEntity

interface ProductRepositoryPort {
    fun insertProductRepository(productEntity: ProductEntity): ProductEntity
}