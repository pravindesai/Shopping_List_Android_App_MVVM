package com.example.shoppinglist_mvvm.UI

import com.example.shoppinglist_mvvm.data.db.entities.ShoppingItemTable

interface AppDialogListener {
    fun onAddBtnClicked(item:ShoppingItemTable)

}