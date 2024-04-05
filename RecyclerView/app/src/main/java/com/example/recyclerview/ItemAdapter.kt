package com.example.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private var data: MutableList<String>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(cellView: View): RecyclerView.ViewHolder(cellView){
        var tvData: TextView = cellView.findViewById(R.id.tv_data)
        var btnOk: Button = cellView.findViewById(R.id.btn_ok)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val cell = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_cell, parent, false)
        return ItemViewHolder(cell)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.tvData.text = data[position]
        holder.btnOk.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}