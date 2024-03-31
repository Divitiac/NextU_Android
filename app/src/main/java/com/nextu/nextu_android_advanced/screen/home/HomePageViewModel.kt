package com.nextu.nextu_android_advanced.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nextu.nextu_android_advanced.endpoint.StoreEndpoint
import com.nextu.nextu_android_advanced.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class HomePageViewModel : ViewModel() {

    val productList = MutableStateFlow<List<Product>>(
        listOf()
    )

    private var storeEndpoint: StoreEndpoint? = null

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        val retrofit = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient.build())
            .baseUrl("https://fakestoreapi.com/")
            .build()

        storeEndpoint = retrofit.create(StoreEndpoint::class.java)

        viewModelScope.launch(Dispatchers.IO) {
            fetchAllProducts()
        }
    }


    private suspend fun fetchAllProducts() {
        try {
            val products = storeEndpoint?.getAllProducts()
            products?.let {
                productList.update { products }
            }
            Log.d("HomePageViewModel", "received ${products?.size ?: "0"} products")
        } catch (e: Exception) {
            Log.e("HomePageViewModel", e.message.toString())
        }
    }

}
