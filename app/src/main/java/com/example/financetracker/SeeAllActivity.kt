package com.example.financetracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financetracker.adapter.ActionAdapter
import com.example.financetracker.data.Datasource
import com.example.financetracker.databinding.SeeAllBinding

class SeeAllActivity: AppCompatActivity() {

    lateinit var binding: SeeAllBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SeeAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = Datasource.getAll()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.allList.adapter = ActionAdapter(myDataset)
        binding.allList.layoutManager = linearLayoutManager

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}