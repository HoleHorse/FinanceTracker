package com.example.financetracker.model

import com.example.financetracker.R
import java.time.LocalDate

class Action (private var category: String, private var amount: Double, private var img: Int, private var date: LocalDate) {

    fun getCategory(): String {
        return this.category
    }

    fun getAmount(): Double {
        return this.amount
    }

    fun getImg(): Int {
        return this.img
    }

    fun getDate(): LocalDate {
        return this.date
    }

    fun getStatus(): String {
        return if (this.img == R.drawable.arrow_up_circle_svgrepo_com) {
            "up"
        } else {
            "down"
        }
    }

}