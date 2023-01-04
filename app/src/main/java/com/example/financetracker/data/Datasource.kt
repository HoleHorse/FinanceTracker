package com.example.financetracker.data

import com.example.financetracker.R
import com.example.financetracker.db.DB
import com.example.financetracker.model.Action
import java.time.LocalDate

class Datasource {

    companion object {
        private var actions: MutableList<Action> = mutableListOf()

        fun setActions(actions: MutableList<Action>) {
            this.actions = actions
        }

        fun getRecent(limit: Int): List<Action> {
            return this.actions.takeLast(limit).reversed()
        }

        fun getAll(): List<Action> {
            return this.actions.reversed()
        }

        fun addNew(action: Action) {
            this.actions.add(action)
        }

        fun getNumbers(): Numbers {
            var balance = 0
            var income = 0
            var spent = 0
            for (a in this.actions) {
                if (a.getImg() == R.drawable.arrow_up_circle_svgrepo_com) {
                    balance += a.getAmount()
                    if (!a.getDate().isBefore(LocalDate.now().minusDays(30))) {
                        income += a.getAmount()
                    }
                } else {
                    balance -= a.getAmount()
                    if (!a.getDate().isBefore(LocalDate.now().minusDays(30))) {
                        spent += a.getAmount()
                    }
                }
            }
            return Numbers(balance, income, spent)
        }

    }
}

class Numbers(var balance: Int, var income: Int, var spent: Int)