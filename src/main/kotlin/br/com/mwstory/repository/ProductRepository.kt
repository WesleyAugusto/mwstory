package br.com.mwstory.repository

import br.com.mwstory.model.ProductEntity
import com.mongodb.client.MongoClient
import jakarta.inject.Singleton
import java.util.*

@Singleton
class ProductRepository(private val mongoClient: MongoClient) : ProductRepositoryPort {
    override fun findAllProductsRepository(): List<ProductEntity> {
        return getColaction().find().toList()
    }

    override fun insertProductRepository(productEntity: ProductEntity): ProductEntity {
        productEntity.id = UUID.randomUUID().toString()
        val result = getColaction().insertOne(productEntity)
        return productEntity
    }

    private fun getColaction() =
        mongoClient.getDatabase("mwstory").getCollection("product", ProductEntity::class.java)
}