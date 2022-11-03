package br.com.mwstory.service

import br.com.mwstory.model.Product
import br.com.mwstory.model.ProductEntity

interface ProductServicePort {
    fun postProduct(requestProduct: Product): ProductEntity
}