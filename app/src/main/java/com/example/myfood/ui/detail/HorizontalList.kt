package com.example.myfood.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfood.R
import com.example.myfood.model.data.OtherFoods

class HorizontalList(private val data: List<OtherFoods>): RecyclerView.Adapter<HorizontalList.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var image: ImageView = itemView.findViewById(R.id.img_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_horizontal_food, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.tvName.text = data[position].name
        Glide.with(holder.itemView.context)
            .load(data[position].image)
            .into(holder.image)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(data[position].foodId) }
    }

    override fun getItemCount(): Int = data.size

    interface OnItemClickCallback {
        fun onItemClicked(foodId: String)
    }
}