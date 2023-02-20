package com.example.financetracker

//noinspection SuspiciousImport
import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financetracker.adapter.DetailAdapter
import com.example.financetracker.data.Datasource
import com.example.financetracker.data.Numbers
import com.example.financetracker.databinding.DetailedBinding
import java.text.NumberFormat


class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: DetailedBinding
    private val options = arrayOf(
        "day",
        "2 days",
        "3 days",
        "5 days",
        "week",
        "2 weeks",
        "month",
        "3 month",
        "6 month",
        "year"
    )
    private val optionsInDays = arrayOf<Long>(1, 2, 3, 5, 7, 14, 30, 90, 182, 365)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ctx = this

        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        val spinner = binding.spinner
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, index: Int, p2: Long) {
                val nums: Numbers = Datasource.getNumbers(optionsInDays[index])
                displayData(nums.income, nums.spent)
                val linearLayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
                binding.recyclerView.adapter = DetailAdapter(Datasource.getDetailedData(optionsInDays[index]))
                binding.recyclerView.layoutManager = linearLayoutManager
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    private fun displayData(income: Double, spent: Double) {
        binding.monthIncome.text =
            getString(
                com.example.financetracker.R.string.income_num,
                NumberFormat.getIntegerInstance().format(income)
            )
        binding.monthSpent.text =
            getString(
                com.example.financetracker.R.string.spent_num,
                NumberFormat.getIntegerInstance().format(spent)
            )
    }

}