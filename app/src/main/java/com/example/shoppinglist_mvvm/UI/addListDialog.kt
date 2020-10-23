package com.example.shoppinglist_mvvm.UI

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist_mvvm.R
import com.example.shoppinglist_mvvm.data.db.entities.ShoppingItemTable
import kotlinx.android.synthetic.main.additemdialog.*

class addListDialog(cotext:Context, var addDialogListener: AppDialogListener):AppCompatDialog(cotext) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.additemdialog)

        okBtn.setOnClickListener {
            val name = itemET.text.toString()
            val amt = amtET.text.toString()

            if(name.isEmpty() || amt.isEmpty()){
                 Toast.makeText(context, "Enter all data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItemTable(name, amt.toInt())
            addDialogListener.onAddBtnClicked(item)
            dismiss()
        }

        cnclBtn.setOnClickListener {
            cancel()
        }
    }
}