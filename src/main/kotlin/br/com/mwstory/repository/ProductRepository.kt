package br.com.mwstory.repository

import br.com.mwstory.model.Product
import br.com.mwstory.model.ProductEntity
import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import jakarta.inject.Singleton
import java.util.*

@Singleton
class ProductRepository(private val mongoClient: MongoClient) : ProductRepositoryPort {
    override fun getOneProductsRepository(id: String): ProductEntity? {
        return getColaction().find(Filters.eq("_id", id)).first()
    }

    override fun findAllProductsRepository(): List<ProductEntity> {
        return getColaction().find().toList()
    }

    override fun insertProductRepository(productEntity: ProductEntity): ProductEntity {
        productEntity.id = UUID.randomUUID().toString()
        val result = getColaction().insertOne(productEntity)
        return productEntity
    }

    override fun putProduct(requestProduct: Product): ProductEntity {
        val productEntity = ProductEntity(
            requestProduct.id,
            requestProduct.name,
            requestProduct.price,
            requestProduct.quantity,
            requestProduct.inventory,
            requestProduct.category
        )
        getColaction().replaceOne(Filters.eq("_id", requestProduct.id), productEntity)
        return productEntity
    }

    override fun deleteProduct(id: String): ProductEntity? {
        return getColaction().findOneAndDelete(Filters.eq("_id", id))
    }

    private fun getColaction() =
        mongoClient.getDatabase("mwstory").getCollection("product", ProductEntity::class.java)
}