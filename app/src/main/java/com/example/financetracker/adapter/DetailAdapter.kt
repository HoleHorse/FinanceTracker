package com.example.financetracker.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.financetracker.R
import com.example.financetracker.model.Detail

class DetailAdapter(private var dataset: List<Detail>) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgState: ImageView
        val category: TextView
        val amount: TextView
        val percentage: TextView
        init {
            imgState = itemView.findViewById(R.id.img_state)
            category = itemView.findViewById(R.id.category)
            amount = itemView.findViewById(R.id.amount)
            percentage = itemView.findViewById(R.id.percentage)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val detail: Detail = dataset[position]
        holder.category.text = "Category: " + detail.getCategory()
        holder.amount.text = "Amount: " + detail.getAmount().toString()
        holder.imgState.setImageResource(detail.getImg())
        holder.percentage.text = "Percentage: " + detail.getPercentage() + "%"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.action_card, parent, false)
        return DetailViewHolder(view)
    }

    override fun getItemCount() = dataset.size
}
