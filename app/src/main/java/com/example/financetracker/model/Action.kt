package com.example.financetracker.model

data class Action (private var category: String, private var amount: Int, private var img: Int) {
    fun getCategory(): String {
        return this.category
    }
    fun getAmount(): Int {
        return this.amount
    }
    fun getImg(): Int {
        return this.img
    }
}