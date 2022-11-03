package br.com.mwstory.model

import br.com.mwstory.annotations.NoArg
import io.micronaut.core.annotation.Introspected

@Introspected
@NoArg
data class ProductEntity(
    var id: String?,
    var name: String,
    var price: Double,
    var quantity: Int,
    var inventory: Int,
    var category: Category
)