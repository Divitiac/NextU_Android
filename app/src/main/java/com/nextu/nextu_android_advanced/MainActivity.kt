package com.nextu.nextu_android_advanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nextu.nextu_android_advanced.ui.theme.NextU_android_advancedTheme


/**
 * A faire :
 *  - Déclarer un objet Product qui nous servira pour avoir du contenu dans la carte
 *  - Créer un composant nommé ProductCard qui permettra l'affichage de la carte produit
 *  - Créer une preview pour coder plus rapidement et améliorer la lisibilité des vues lorsqu'on navigue dans nos classes
 *
 *  exemple de produit :
 *   Product(
 *     category = "Coffee",
 *     description = "A rich blend of premium coffee beans sourced from Colombia and Ethiopia, roasted to perfection.",
 *     id = 123456,
 *     image = "https://tinyurl.com/vtymn7w5",
 *     price = 9.99,
 *     rating = Rating(count = 256, rate = 4.5),
 *     title = "Premium Blend Coffee"
 *   )
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextU_android_advancedTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Ajouter ici le produit avec un remember
                    // Retirer Greetings et le remplacer par un ProductCard
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Remplacer cette preview par la preview de ProductCard
    NextU_android_advancedTheme {
        Greeting("Android")
    }
}
