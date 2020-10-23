package com.example.shoppinglist_mvvm.data.db.entities

import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShoppingItemTable")
class ShoppingItemTable(
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "ammount")
    var ammount: Int) {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null



}