package br.com.mwstory.service

import br.com.mwstory.model.Product
import br.com.mwstory.model.ProductEntity
import br.com.mwstory.repository.ProductRepositoryPort
import jakarta.inject.Singleton

@Singleton
class ProductService(private val productRepositoryPort: ProductRepositoryPort) : ProductServicePort {
    override fun postProduct(requestProduct: Product): ProductEntity {
        val productEntity = ProductEntity(
            requestProduct._id.toString(),
            requestProduct.name,
            requestProduct.price,
            requestProduct.quantity,
            requestProduct.inventory,
            requestProduct.category
        )
        return productRepositoryPort.insertProductRepository(productEntity)
    }

}