package br.com.mwstory.repository

import br.com.mwstory.model.ProductEntity
import com.mongodb.client.MongoClient
import jakarta.inject.Singleton

@Singleton
class ProductRepository(private val mongoClient: MongoClient) : ProductRepositoryPort {
    override fun insertProductRepository(productEntity: ProductEntity): ProductEntity {
        val result = getColaction().insertOne(productEntity).insertedId
        productEntity._id = result?.asObjectId()?.value.toString()
        return productEntity
    }

    private fun getColaction() =
        mongoClient.getDatabase("mwstory").getCollection("product", ProductEntity::class.java)
}
