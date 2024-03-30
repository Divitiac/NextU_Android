package com.nextu.nextu_android_advanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.nextu.nextu_android_advanced.screen.home.HomePageScreen
import com.nextu.nextu_android_advanced.screen.home.HomePageViewModel
import com.nextu.nextu_android_advanced.ui.theme.NextU_android_advancedTheme


/**
 * A faire:
 *
 * Créer l’écran HomePageScreen en prévision des prochains écrans. Il va être accompagné d’un ViewModel
 *
 * On va mettre le produit dans le viewmodel et le rendre disponible pour l’écran
 *
 * On va brancher le HomePageScreen pour afficher le produit dans la carte
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextU_android_advancedTheme {
                val homePageViewModel = remember {
                    HomePageViewModel()
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomePageScreen(homePageViewModel)
                }
            }
        }
    }
}

