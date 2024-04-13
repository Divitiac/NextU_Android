package com.nextu.nextu_android_advanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nextu.nextu_android_advanced.ui.screen.detail.ProductDetailScreen
import com.nextu.nextu_android_advanced.ui.screen.detail.ProductDetailViewModel
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextU_android_advancedTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAppNavHost()
                }
            }
        }
    }

    @Composable
    fun MyAppNavHost(
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController(),
        startDestination: String = NavigationRoute.HOME.title
    ) {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination
        ) {
            composable(NavigationRoute.HOME.title) {
                val homePageViewModel = remember {
                    HomePageViewModel((application as NextUApplication).container.storeRepository)
                }
                HomePageScreen(homePageViewModel = homePageViewModel, navToProductDetail = { productId ->
                    navController.navigate(
                        NavigationRoute.DETAIL.title.replace(
                            "{productId}",
                            productId
                        )
                    )
                })
            }
            composable(
                NavigationRoute.DETAIL.title,
                arguments = listOf(navArgument("productId") { type = NavType.StringType })
            ) { backStackEntry ->
                val productDetailViewModel = remember {
                    ProductDetailViewModel()
                }
                ProductDetailScreen(
                    viewModel = productDetailViewModel,
                )
            }
        }
    }

    /**
     * Définition des routes de navigation entre les écrans
     * La route Détail demande un argument de navigation: un productId
     */
    enum class NavigationRoute(val title: String) {
        HOME("home"),
        DETAIL("detail/{productId}")
    }

}

