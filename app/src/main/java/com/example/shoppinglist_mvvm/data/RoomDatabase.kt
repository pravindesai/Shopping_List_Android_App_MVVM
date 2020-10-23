package com.example.shoppinglist_mvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist_mvvm.data.db.entities.ShoppingItemTable
import com.example.shoppinglist_mvvm.data.db.shoppingDao

@Database(entities = [ShoppingItemTable::class], version = 1)
abstract class ShoppingDataBase:RoomDatabase(){

    abstract fun getShoppinfDao(): shoppingDao

    companion object{
        @Volatile
        private var instance : ShoppingDataBase? = null
        private var LOCK = Any()

        operator fun invoke (context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDB(context).also { instance = it }
        }

        private fun createDB(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                        ShoppingDataBase::class.java,
                "ShoppingDB.db").build()
    }

}