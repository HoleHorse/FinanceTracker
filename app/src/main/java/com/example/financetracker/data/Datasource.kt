package com.example.financetracker.data

import com.example.financetracker.R
import com.example.financetracker.model.Action
import com.example.financetracker.model.Detail
import java.math.BigDecimal
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

        fun getNumbers(days: Long): Numbers {
            var balance = 0.0
            var income = 0.0
            var spent = 0.0
            for (a in this.actions) {
                if (a.getStatus() == "up") {
                    balance += a.getAmount()
                    if (!a.getDate().isBefore(LocalDate.now().minusDays(days))) {
                        income += a.getAmount()
                    }
                } else {
                    balance -= a.getAmount()
                    if (!a.getDate().isBefore(LocalDate.now().minusDays(days))) {
                        spent += a.getAmount()
                    }
                }
            }
            return Numbers(balance, income, spent)
        }

        fun getDetailedData(days: Long): List<Detail> {
            val res = mutableListOf<Detail>()
            val categoriesSpent = mutableSetOf<String>()
            val categoriesIncome = mutableSetOf<String>()
            var spent = 0.0
            var income = 0.0
            for (a in this.actions) {
                if (a.getStatus() == "up") {
                    if (!a.getDate().isBefore(LocalDate.now().minusDays(days))) {
                        categoriesIncome.add(a.getCategory())
                        income += a.getAmount()
                    }
                } else {
                    if (!a.getDate().isBefore(LocalDate.now().minusDays(days))) {
                        categoriesSpent.add(a.getCategory())
                        spent += a.getAmount()
                    }
                }
            }
            categoriesSpent.forEach {
                var amount = 0.0
                for (a in this.actions) {
                    if (a.getCategory() == it && checkDate(days, a) && a.getStatus() == "down") {
                        amount += a.getAmount()
                    }
                }
                val percentage = BigDecimal(amount/spent *100).setScale(3, BigDecimal.ROUND_HALF_UP)
                val detail =
                    Detail(it, amount, R.drawable.arrow_down_circle_svgrepo_com, percentage.toDouble())
                res.add(detail)
            }
            categoriesIncome.forEach {
                var amount = 0.0
                for (a in this.actions) {
                    if (a.getCategory() == it && checkDate(days, a) && a.getStatus() == "up") {
                        amount += a.getAmount()
                    }
                }
                val percentage = BigDecimal(amount/income *100).setScale(3, BigDecimal.ROUND_HALF_UP)
                val detail =
                    Detail(it, amount, R.drawable.arrow_up_circle_svgrepo_com, percentage.toDouble())
                res.add(detail)
            }
            return res
        }

        private fun checkDate(days: Long, a: Action): Boolean {
            return !a.getDate().isBefore(LocalDate.now().minusDays(days))
        }

    }
}

class Numbers(var balance: Double, var income: Double, var spent: Double)