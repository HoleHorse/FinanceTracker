package com.example.financetracker.data

import com.example.financetracker.R
import com.example.financetracker.model.Action

class Datasource {
    fun getRecent(): List<Action> {
        return listOf<Action>(
            Action("Food", 5000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Leisure", 20000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Gift", 15000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Leisure", 30000, R.drawable.arrow_down_circle_svgrepo_com)
        )
    }
    fun getAll(): List<Action> {
        return listOf<Action>(
            Action("Food", 5000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Leisure", 20000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Gift", 15000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Leisure", 30000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Food", 5000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Leisure", 20000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Gift", 15000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Leisure", 30000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Food", 5000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Leisure", 20000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Gift", 15000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com),
            Action("Leisure", 30000, R.drawable.arrow_down_circle_svgrepo_com)
        )
    }
}