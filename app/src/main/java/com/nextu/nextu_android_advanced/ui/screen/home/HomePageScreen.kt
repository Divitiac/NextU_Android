package com.nextu.nextu_android_advanced.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nextu.nextu_android_advanced.ui.component.LoadingContent
import com.nextu.nextu_android_advanced.ui.extension.OnStartEffect
import com.nextu.nextu_android_advanced.ui.screen.home.component.ProductListContent

@Composable
fun HomePageScreen(homePageViewModel: HomePageViewModel) {
    val state by homePageViewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    // On va charger la liste de produits et catégories depuis le OnStart() du lifecycle
    OnStartEffect(lifecycleOwner) {
        homePageViewModel.loadProducts()
    }

    Column(
        Modifier
            .fillMaxSize()
    ) {
        if (state.isLoading) {
            LoadingContent()
        } else {
            ProductListContent(
                state.categories,
                state.products
            )
        }
    }
}

