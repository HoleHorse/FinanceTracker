package com.example.financetracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financetracker.data.Datasource
import com.example.financetracker.databinding.AddNewBinding
import com.example.financetracker.model.Action
import java.time.LocalDate

class AddNewActivity: AppCompatActivity() {

    lateinit var binding: AddNewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.button.setOnClickListener {
            addNew()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun addNew() {
        var amount = binding.inputAmount.text.toString().toIntOrNull()
        var category = binding.inputCategory.text.toString()
        if (amount == null || amount < 0) {
            amount = 0
        }
        if (category == "") {
            category = "Undefined"
        }
        if (binding.status.checkedRadioButtonId == R.id.income) {
            Datasource.addNew(Action(category, amount, R.drawable.arrow_up_circle_svgrepo_com, LocalDate.now()))
        } else {
            Datasource.addNew(Action(category, amount, R.drawable.arrow_down_circle_svgrepo_com, LocalDate.now()))
        }
    }

}