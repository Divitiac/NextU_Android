package com.nextu.nextu_android_advanced.ui.screen.home

import ProductCard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nextu.nextu_android_advanced.ui.extension.OnStartEffect
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.model.Rating
import com.nextu.nextu_android_advanced.ui.component.LoadingContent
import com.nextu.nextu_android_advanced.ui.screen.home.component.ProductListContent
import com.nextu.nextu_android_advanced.ui.theme.NextU_android_advancedTheme

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


@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    NextU_android_advancedTheme {
        ProductCard(
            Product(
                category = "Coffee",
                description = "A rich blend of premium coffee beans sourced from Colombia and Ethiopia, roasted to perfection.",
                id = 123456,
                image = "https://tinyurl.com/vtymn7w5",
                price = 9.99,
                rating = Rating(count = 256, rate = 4.5),
                title = "Premium Blend Coffee"
            )
        )
    }
}
