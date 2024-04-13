package com.nextu.nextu_android_advanced.data.store

import android.util.Log
import com.nextu.nextu_android_advanced.model.Category
import com.nextu.nextu_android_advanced.model.Product


class StoreRepository(private val endpoint: StoreEndpoint) {

    companion object {
        const val TAG = "StoreRepository"
    }

    suspend fun getAllProducts(): List<Product> {
        return try {
            endpoint.getAllProducts()
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            listOf()
        }
    }

    suspend fun getCategories(): List<Category> {
        return try {
            endpoint.getAllCategories()
                .map { categoryName -> Category(name = categoryName) }  // ici on transforme les string en objets Category
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            listOf()
        }

    }

    suspend fun getProductsByCategory(category: String): List<Product> {
        return try {
            endpoint.getProductsByCategory(category)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            listOf()
        }
    }

    suspend fun getProductById(productId: String): Product? {
        return try {
            endpoint.getProductById(productId)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            null
        }
    }
}