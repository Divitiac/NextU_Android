package com.nextu.nextu_android_advanced.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nextu.nextu_android_advanced.model.Category
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.data.store.StoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomePageViewModel(private val storeRepository: StoreRepository) : ViewModel() {

    companion object {
        const val CATEGORY_ALL = "All"
    }

    private val _state = MutableStateFlow<HomePageState>(HomePageState())
    val state: StateFlow<HomePageState> = _state.asStateFlow()

    data class HomePageState(
        val products: List<Product> = listOf(),
        val categories: List<Category> = listOf(),
        val isLoading: Boolean = false,
    )

    fun loadProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { state ->
                state.copy(
                    isLoading = true
                )
            }
            fetchCategories()
            fetchAllProducts()
            _state.update { state ->
                state.copy(
                    isLoading = false
                )
            }
        }
    }


    private suspend fun fetchAllProducts() {
        val productRequest = storeRepository.getAllProducts()
        _state.update { state ->
            state.copy(
                products = productRequest,
            )
        }
    }

    private suspend fun fetchCategories() {
        val categoryList = storeRepository.getCategories()
        _state.update { state ->
            state.copy(
                categories = categoryList
                    .toMutableList()                                        // On rend la liste mutable
                    .apply {                         // Ici on ajoute l'élément ALL qui n'est pas retourné par le webservice et qui sera notre première catégorie
                        add(0, Category(CATEGORY_ALL, true))
                    }.toList(),
            )
        }
    }

    fun selectCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { state ->
                // Avec le map on itère sur les catégories et on set son isSelected à true si la catégorie à le même nom que celle qui a été sélectionnée
                state.copy(categories = state.categories.map { localCategory ->
                    localCategory.isSelected = localCategory.name == category.name
                    localCategory
                })
            }

            if (category.name == CATEGORY_ALL) {
                fetchAllProducts()
            } else {
                loadProductsByCategory(category)
            }
        }
    }

    private suspend fun loadProductsByCategory(category: Category) {
        val productRequest = storeRepository.getProductsByCategory(category.name)
        _state.update { it.copy(products = productRequest) }
    }

}
