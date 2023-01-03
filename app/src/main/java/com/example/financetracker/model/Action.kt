package com.example.financetracker.model

import java.time.LocalDate

data class Action (private var category: String, private var amount: Int, private var img: Int, private var date: LocalDate) {

    fun getCategory(): String {
        return this.category
    }

    fun getAmount(): Int {
        return this.amount
    }

    fun getImg(): Int {
        return this.img
    }

    fun getDate(): LocalDate {
        return this.date
    }

}