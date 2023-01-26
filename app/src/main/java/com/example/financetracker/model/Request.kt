package com.example.financetracker.model

class Request(
    var result: String,
    var base_code: String,
    var target_code: String,
    var conversion_rate: Double,
    var conversion_result: Double
)