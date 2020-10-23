package com.example.shoppinglist_mvvm.UI
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist_mvvm.Other.itemAdapter
import com.example.shoppinglist_mvvm.R
import com.example.shoppinglist_mvvm.UI.ShoppingList.ShoppingViewModel
import com.example.shoppinglist_mvvm.UI.ShoppingList.viewModelFactory
import com.example.shoppinglist_mvvm.data.Repository.ShoppingRepository
import com.example.shoppinglist_mvvm.data.ShoppingDataBase
import com.example.shoppinglist_mvvm.data.db.entities.ShoppingItemTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ShoppingDataBase(this)
        val repository = ShoppingRepository(database)
        val factory = viewModelFactory(repository)
        //deprecated
        //val ViewModel = ViewModelProviders.of(  this,factory).get(ShoppingViewModel::class.java)
        val ViewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)


        val adapter = itemAdapter(listOf(), ViewModel)

        Rv.layoutManager = LinearLayoutManager(this)
        Rv.adapter = adapter
        ViewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        FAB.setOnClickListener {
            addListDialog(this, object : AppDialogListener{
                override fun onAddBtnClicked(item: ShoppingItemTable) {
                    ViewModel.upsert(item)
                }
            }).show()
        }
    }
}