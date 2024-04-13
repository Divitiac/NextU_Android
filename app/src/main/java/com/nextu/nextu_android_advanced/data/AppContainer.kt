package com.nextu.nextu_android_advanced.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nextu.nextu_android_advanced.data.store.StoreEndpoint
import com.nextu.nextu_android_advanced.data.store.StoreRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

/**
 * Conteneur pour l'injection de dépendance
 */
interface AppContainer {
    val storeRepository: StoreRepository
}

/**
 * Les variables sont initialisées à la demande avec le lazy et sont partagées par tous les composants de l'app
 */
class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://fakestoreapi.com/"

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    /**
     * Création du builder Retrofit avec le converter serialization et le client okHttp
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .client(okHttpClient.build())
        .baseUrl(baseUrl)
        .build()

    private val storeEndpoint: StoreEndpoint by lazy {
        retrofit.create(StoreEndpoint::class.java)
    }

    /**
     * Implémentation de l'object disponible à l'injection
     */
    override val storeRepository: StoreRepository by lazy {
        StoreRepository(storeEndpoint)
    }


}