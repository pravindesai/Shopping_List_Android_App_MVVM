package com.example.shoppinglist_mvvm.Other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist_mvvm.R
import com.example.shoppinglist_mvvm.UI.ShoppingList.ShoppingViewModel
import com.example.shoppinglist_mvvm.data.db.entities.ShoppingItemTable
import kotlinx.android.synthetic.main.shopping_item.view.*

class itemAdapter(
    var items:List<ShoppingItemTable>,
    private var viewModel:ShoppingViewModel
):RecyclerView.Adapter<itemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
            return ShoppingViewHolder(view)
        }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppngItem = items[position]
        holder.itemView.tvName.text = curShoppngItem.name
        holder.itemView.tvAmt.text = curShoppngItem.ammount.toString()

        holder.itemView.delete.setOnClickListener {
            viewModel.delete(curShoppngItem)
        }
        holder.itemView.Inc.setOnClickListener {
            curShoppngItem.ammount++
            viewModel.upsert(curShoppngItem)
        }
        holder.itemView.Dec.setOnClickListener {
            if (curShoppngItem.ammount>0)
                {
                    curShoppngItem.ammount--
                    viewModel.upsert(curShoppngItem)
                }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}