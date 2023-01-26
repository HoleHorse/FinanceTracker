package com.example.financetracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financetracker.adapter.ActionAdapter
import com.example.financetracker.data.Datasource
import com.example.financetracker.data.Numbers
import com.example.financetracker.databinding.ActivityMainBinding
import com.example.financetracker.db.DB
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DB.getInstance(this@MainActivity).getData()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recentList.adapter = ActionAdapter(Datasource.getRecent(7))
        binding.recentList.layoutManager = linearLayoutManager

        binding.seeAll.setOnClickListener {
            startActivity(Intent(this, SeeAllActivity::class.java))
        }

        binding.addBtn.setOnClickListener {
            startActivity(Intent(this, AddNewActivity::class.java))
        }

        binding.convert.setOnClickListener {
            startActivity(Intent(this, CurrConvActivity::class.java))
        }

        val nums: Numbers = Datasource.getNumbers()
        displayData(nums.balance, nums.income, nums.spent)

    }

    private fun displayData(balance: Int, income: Int, spent: Int) {
        binding.balance.text =
            getString(R.string.balance, NumberFormat.getIntegerInstance().format(balance))
        binding.monthIncome.text =
            getString(R.string.income_num, NumberFormat.getIntegerInstance().format(income))
        binding.monthSpent.text =
            getString(R.string.spent_num, NumberFormat.getIntegerInstance().format(spent))
    }
}
