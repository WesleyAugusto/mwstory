package br.com.mwstory.controller

import br.com.mwstory.model.Product
import br.com.mwstory.model.ProductEntity
import br.com.mwstory.service.ProductServicePort
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*

@Controller("/product")
class ProductController(private val productServicePort: ProductServicePort) {

    @Get
    fun getAllProducts(): MutableHttpResponse<List<ProductEntity>>? {
        return HttpResponse.ok(productServicePort.getAllProducts())
    }

    @Get("/{id}")
    fun getOneProduct(@Parameter id: String): MutableHttpResponse<ProductEntity?>? {
        return HttpResponse.ok(productServicePort.getOneProduct(id))
    }

    @Post
    fun postProduct(@Body request: Product): MutableHttpResponse<ProductEntity>? {
        return HttpResponse.created(productServicePort.postProduct(request))
    }

    @Put
    fun putProduct(@Body request: Product): MutableHttpResponse<ProductEntity>? {
        return HttpResponse.ok(productServicePort.putProduct(request))
    }

    @Delete("/{id}")
    fun deleteProduct(@Parameter id: String): MutableHttpResponse<ProductEntity?>? {
        return HttpResponse.ok(productServicePort.deleteProduct(id))
    }
}