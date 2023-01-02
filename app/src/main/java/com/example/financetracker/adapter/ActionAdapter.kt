package com.example.financetracker.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.financetracker.R
import com.example.financetracker.model.Action

class ActionAdapter(private val context: Context, private var dataset: List<Action>) : RecyclerView.Adapter<ActionAdapter.ActionViewHolder>() {
    class ActionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_state: ImageView
        val category: TextView
        val amount: TextView
        init {
            img_state = itemView.findViewById(R.id.img_state)
            category = itemView.findViewById(R.id.category)
            amount = itemView.findViewById(R.id.amount)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionAdapter.ActionViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.action_card, parent, false)
        return ActionViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
        val action: Action = dataset[position]
        holder.category.text = "Category: " + action.getCategory()
        holder.amount.text = "Amount: " + action.getAmount().toString()
        holder.img_state.setImageResource(action.getImg())
    }

    override fun getItemCount() = dataset.size

    // Constructor
    init {
    }
}
