package com.example.shoppinglist_mvvm.data.Repository

import com.example.shoppinglist_mvvm.data.ShoppingDataBase
import com.example.shoppinglist_mvvm.data.db.entities.ShoppingItemTable

class ShoppingRepository(
    private val db:ShoppingDataBase
) {
        suspend fun upsert(item:ShoppingItemTable) = db.getShoppinfDao().upsert(item)

        suspend fun delete(item: ShoppingItemTable) = db.getShoppinfDao().delete(item)

        fun getAllItems() = db.getShoppinfDao().getAllItems()
}