package com.nextu.nextu_android_advanced.screen.home

import androidx.lifecycle.ViewModel
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.model.Rating
import kotlinx.coroutines.flow.MutableStateFlow

class HomePageViewModel : ViewModel() {

    val product = MutableStateFlow<Product>(
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
