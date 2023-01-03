package com.example.financetracker.data

import com.example.financetracker.R
import com.example.financetracker.model.Action

class Datasource {
    private var actions: MutableList<Action> = mutableListOf(
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

    fun getRecent(limit: Int): List<Action> {
        return actions.takeLast(limit).reversed()
    }

    fun getAll(): List<Action> {
        return actions.reversed()
    }

    fun addNew(action: Action) {
        actions.add(action)
    }

    fun getNumbers(): Numbers {
        var balance = 0
        var income = 0
        var spent = 0
        for (a in actions) {
            if (a.getImg() == R.drawable.arrow_up_circle_svgrepo_com) {
                balance += a.getAmount()
                income += a.getAmount()
            } else {
                balance -= a.getAmount()
                spent += a.getAmount()
            }
        }
        return Numbers(balance, income, spent)
    }
}

class Numbers(var balance: Int, var income: Int, var spent: Int)