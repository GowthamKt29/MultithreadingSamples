package com.example.androidmultithreadingsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    val context: Context,
    private val localData: ArrayList<LocalData>,
    private val onItemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: LocalData) {
            itemView.tv.text = data.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = localData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(localData.get(position))
        holder.itemView.setOnClickListener {
            onItemClickListener(position)
        }
    }


}