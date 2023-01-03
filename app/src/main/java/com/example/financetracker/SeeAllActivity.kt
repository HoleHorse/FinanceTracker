package com.example.financetracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.financetracker.adapter.ActionAdapter
import com.example.financetracker.data.Datasource

class SeeAllActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.see_all)
        val myDataset = Datasource().getAll()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.all_list)
        recyclerView.adapter = ActionAdapter(this, myDataset, myDataset.size)
        recyclerView.layoutManager = linearLayoutManager
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}