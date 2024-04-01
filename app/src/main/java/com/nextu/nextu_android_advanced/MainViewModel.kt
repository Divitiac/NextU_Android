package com.nextu.nextu_android_advanced

import androidx.lifecycle.ViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nextu.nextu_android_advanced.store.StoreEndpoint
import com.nextu.nextu_android_advanced.store.StoreRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class MainViewModel : ViewModel() {
    private var storeRepository: StoreRepository? = null

    fun createStoreRepository(): StoreRepository {
        return if (storeRepository != null) storeRepository!!
        else {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

            val retrofit = Retrofit.Builder()
                .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                .client(okHttpClient.build())
                .baseUrl("https://fakestoreapi.com/")
                .build()


            val storeEndpoint = retrofit.create(StoreEndpoint::class.java)


            storeRepository = StoreRepository(storeEndpoint)
            return storeRepository!!
        }
    }
}

