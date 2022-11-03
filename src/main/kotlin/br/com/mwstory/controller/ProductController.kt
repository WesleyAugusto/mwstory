package br.com.mwstory.controller

import br.com.mwstory.model.Product
import br.com.mwstory.model.ProductEntity
import br.com.mwstory.service.ProductServicePort
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/product")
class ProductController(private val productServicePort: ProductServicePort) {

    @Post
    fun postProduct(@Body request: Product): ProductEntity {
        return productServicePort.postProduct(request)
    }
}