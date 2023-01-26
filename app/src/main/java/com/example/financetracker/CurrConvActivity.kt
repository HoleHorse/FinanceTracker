package com.example.financetracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financetracker.databinding.CurrConvertBinding
import com.example.financetracker.model.Request
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class CurrConvActivity : AppCompatActivity() {

    lateinit var binding: CurrConvertBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CurrConvertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convert.setOnClickListener {
            convert().start()
        }
    }

    private fun convert(): Thread {
        return Thread {
            val from = binding.fromInput.text
            val to = binding.toInput.text
            val amount = binding.amountInput.text
            if (amount.toString().toDouble() < 0.0) {
                updateUI("\n\nPlease, insert value more than or equal to 0")
                return@Thread
            }
            val url =
                "https://v6.exchangerate-api.com/v6/6b9ce7fd5b29002b1084f81d/pair/$from/$to/$amount"
            val connection = URL(url).openConnection() as HttpsURLConnection
            if (connection.responseCode == 200) {
                val inputSystem = connection.inputStream
                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                val req = Gson().fromJson(inputStreamReader, Request::class.java)
                updateUI(req.conversion_result.toString())
                inputStreamReader.close()
                inputSystem.close()
            } else {
                updateUI("An error occurred, make sure you are using correct codes")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun updateUI(res: String) {
        runOnUiThread {
            kotlin.run {
                binding.result.text = "Result: $res"
            }
        }
    }
}