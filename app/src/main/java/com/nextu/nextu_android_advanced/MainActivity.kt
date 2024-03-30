package com.nextu.nextu_android_advanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.model.Rating
import com.nextu.nextu_android_advanced.ui.theme.NextU_android_advancedTheme
import com.nextu.nextu_android_advanced.ui.theme.Typography


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextU_android_advancedTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * -> Déclarer un objet Product qui nous servira pour avoir du contenu dans la carte
                     */
                    val product = remember {
                        mutableStateOf(
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

                    Column {
                        ProductCard(product = product.value)
                    }
                }
            }
        }
    }
}


/**
 * -> Créer un composant nommé ProductCard qui permettra l'affichage de la carte produit avec une image, le titre du produit et son prix
 */
@Composable
fun ProductCard(product: Product, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = "Image of the product ${product.title}",
                placeholder = painterResource(id = R.drawable.ic_coffee),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("${product.price} €", fontWeight = FontWeight.Bold)
                Text(product.title, style = Typography.labelSmall.copy(fontSize = 14.sp))
            }
        }
    }
}


/**
 * -> Créer une preview pour coder plus rapidement et améliorer la lisibilité des vues lorsqu'on navigue dans nos classes
 */
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
