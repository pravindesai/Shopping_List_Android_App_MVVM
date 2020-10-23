package com.example.shoppinglist_mvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist_mvvm.data.db.entities.ShoppingItemTable

@Dao
interface shoppingDao {
    //suspends keyword used when we want to run function in asynck task
    //upsert works as update if data already available or insert whne not

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItemTable)

    @Delete
    suspend fun delete(item: ShoppingItemTable)

    @Query("select * from ShoppingItemTable")
    fun getAllItems() : LiveData<List<ShoppingItemTable>>

}