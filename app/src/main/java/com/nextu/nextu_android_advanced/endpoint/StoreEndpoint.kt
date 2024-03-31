package com.nextu.nextu_android_advanced.endpoint

import com.nextu.nextu_android_advanced.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreEndpoint {

    @GET("products")
    suspend fun getAllProducts(): List<Product>

    @GET("products/{productId}")
    suspend fun getProductById(@Path("productId") productId: String): Product?

    @GET("products/category/{category}")
    suspend fun getProductsByCategory(@Path("category") category: String): List<Product>

    @GET("products/categories")
    suspend fun getAllCategories(): List<String>


}