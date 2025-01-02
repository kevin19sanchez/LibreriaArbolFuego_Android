package com.example.libreriaarboldefuegodemo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.libreriaarboldefuegodemo.Model.Review
import com.example.libreriaarboldefuegodemo.R

class CatalogoFragmentAdapter(private val catalog:List<Review>): RecyclerView.Adapter<CatalogoFragmentAdapter.CatalogViewHolder>(){

    class CatalogViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_book,parent, false)
        return CatalogViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogoFragmentAdapter.CatalogViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = catalog.size
}