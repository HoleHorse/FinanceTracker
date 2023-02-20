package com.example.financetracker.model

class Detail(private var category: String, private var amount: Double, private var img: Int, private var percentage: Double) {

    fun getCategory(): String {
        return this.category
    }

    fun getAmount(): Double {
        return this.amount
    }

    fun getImg(): Int {
        return this.img
    }

    fun getPercentage(): Double {
        return this.percentage
    }

}