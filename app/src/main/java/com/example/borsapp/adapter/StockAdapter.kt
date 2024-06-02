package com.example.borsapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.borsapp.R
import com.example.borsapp.databinding.ItemStockBinding
import com.example.borsapp.model.Hisse

open class StockAdapter(var stocks: ArrayList<Hisse>) : RecyclerView.Adapter<StockAdapter.StockViewHolder>() {

    class StockViewHolder(var view: ItemStockBinding) : RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
    val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemStockBinding>(inflater, R.layout.item_stock, parent, false)
        return StockViewHolder(view)
    }

    override fun getItemCount(): Int {
    return stocks.size
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        holder.view.stockText.text = stocks[position].hisseIsim
        holder.view.stockShortText.text=stocks[position].hisseKodu

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateStocks(newStocks: List<Hisse>) {
        stocks=newStocks as ArrayList<Hisse>
        notifyDataSetChanged()
    }


}