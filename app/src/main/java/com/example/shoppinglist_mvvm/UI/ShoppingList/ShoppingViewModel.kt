package com.example.shoppinglist_mvvm.UI.ShoppingList

import androidx.lifecycle.ViewModel
import com.example.shoppinglist_mvvm.data.Repository.ShoppingRepository
import com.example.shoppinglist_mvvm.data.db.entities.ShoppingItemTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
):ViewModel() {

    fun upsert(itemTable: ShoppingItemTable) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(itemTable)
    }

    fun delete(itemTable: ShoppingItemTable) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(itemTable)
    }

    fun getAllItems() = repository.getAllItems()



}