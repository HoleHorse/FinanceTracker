package com.example.financetracker.data

import com.example.financetracker.R
import com.example.financetracker.model.Action
import java.time.LocalDate

class Datasource {

    companion object {
//        private var actions: MutableList<Action> = mutableListOf()
        private var actions: MutableList<Action> = mutableListOf(
            Action("Leisure", 20000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Gift", 15000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Leisure", 30000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Food", 5000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Leisure", 20000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Gift", 15000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Leisure", 30000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.of(2019, 8, 23)),
            Action("Food", 5000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.now()),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.now()),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.now()),
            Action("Leisure", 20000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.now()),
            Action("Gift", 15000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.now()),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.now()),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.now()),
            Action("Leisure", 30000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.now()),
            Action("Food", 5000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.now()),
            Action("Rent", 100000, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.now()),
            Action("Salary", 250000, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.now())
        )

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
//            DB.addNew(action)
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