package com.example.financetracker.model

import com.google.gson.annotations.SerializedName

class Request(
    var result: String,
    var base_code: String,
    var target_code: String,
    var conversion_rate: Double,
    var conversion_result: Double,
    @SerializedName("error-type")
    var errorType: String
)