package com.nextu.nextu_android_advanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.nextu.nextu_android_advanced.ui.screen.home.HomePageScreen
import com.nextu.nextu_android_advanced.ui.screen.home.HomePageViewModel
import com.nextu.nextu_android_advanced.ui.theme.NextU_android_advancedTheme


/**
 * A faire:
 *
 *
 *
 */
class MainActivity : ComponentActivity() {
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NextU_android_advancedTheme {
                val homePageViewModel = remember {
                    HomePageViewModel(viewModel.createStoreManager())
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

