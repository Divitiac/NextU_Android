package com.nextu.nextu_android_advanced.ui.screen.home.component

import ProductCard
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nextu.nextu_android_advanced.model.Category
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.ui.theme.Typography

@Composable
fun ProductListContent(
    categories: List<Category>,
    products: List<Product>,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "${categories.firstOrNull { it.isSelected }?.name ?: ""}",
            style = Typography.titleLarge.copy(fontSize = 32.sp)
        )
        Text("Collection", style = Typography.bodyLarge)
    }

    LazyRow(
        Modifier
            .fillMaxWidth()
            .scrollable(rememberScrollState(), orientation = Orientation.Vertical),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            FilterChip(
                selected = category.isSelected,
                onClick = { /* onClick */ },
                label = { Text(category.name) },
                modifier = Modifier.padding(horizontal = 4.dp),
            )
        }
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        items(products.size) { index ->
            val product = products[index]
            ProductCard(
                product = product,
            )
        }
    }
}