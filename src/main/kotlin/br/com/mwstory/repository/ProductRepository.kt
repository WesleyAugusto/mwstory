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
        return try {
            getColaction().find(Filters.eq("_id", id)).first()
        } catch (e: RuntimeException) {
            throw RuntimeException("ERROR: Produto: $id FindOne Product Repository: ${e.message}")
        }
    }

    override fun findAllProductsRepository(): List<ProductEntity> {
        return try {
            getColaction().find().toList()
        } catch (e: RuntimeException) {
            throw RuntimeException("ERROR: FindAll Product Repository: ${e.message}")
        }
    }

    override fun insertProductRepository(productEntity: ProductEntity): ProductEntity {
        return try {
            productEntity.id = UUID.randomUUID().toString()
            val result = getColaction().insertOne(productEntity)
            productEntity
        } catch (e: RuntimeException) {
            throw RuntimeException("ERROR: Produto: ${productEntity.id} Insert Product Repository: ${e.message}")
        }
    }

    override fun putProduct(requestProduct: Product): ProductEntity {
        return try {
            val productEntity = ProductEntity(
                requestProduct.id,
                requestProduct.name,
                requestProduct.price,
                requestProduct.quantity,
                requestProduct.inventory,
                requestProduct.category
            )
            getColaction().replaceOne(Filters.eq("_id", requestProduct.id), productEntity)
            productEntity
        } catch (e: RuntimeException) {
            throw RuntimeException("ERROR: Produto: ${requestProduct.id} Update Product Repository: ${e.message}")
        }
    }

    override fun deleteProduct(id: String): ProductEntity? {
        return try {
            getColaction().findOneAndDelete(Filters.eq("_id", id))
        } catch (e: RuntimeException) {
            throw RuntimeException("ERROR: Produto: $id Delete Product Repository: ${e.message}")
        }
    }

    private fun getColaction() =
        mongoClient.getDatabase("mwstory").getCollection("product", ProductEntity::class.java)
}