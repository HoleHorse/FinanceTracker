package com.example.financetracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.financetracker.adapter.ActionAdapter
import com.example.financetracker.data.Datasource
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().getRecent()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recent_list)
        recyclerView.adapter = ActionAdapter(this, myDataset, 7)
        recyclerView.layoutManager = linearLayoutManager
        val buttonClick = findViewById<FloatingActionButton>(R.id.see_all)
        buttonClick.setOnClickListener {
            val intent = Intent(this, SeeAllActivity::class.java)
            startActivity(intent)
        }
    }
}