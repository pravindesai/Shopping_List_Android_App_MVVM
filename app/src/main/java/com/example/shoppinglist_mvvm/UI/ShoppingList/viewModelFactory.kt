package com.example.shoppinglist_mvvm.UI.ShoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist_mvvm.data.Repository.ShoppingRepository

class viewModelFactory(private val repository: ShoppingRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}