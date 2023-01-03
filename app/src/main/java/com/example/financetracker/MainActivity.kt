package com.example.financetracker

import android.R.attr.button
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.financetracker.adapter.ActionAdapter
import com.example.financetracker.data.Datasource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().getRecent()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recent_list)
        recyclerView.adapter = ActionAdapter(this, myDataset, 7)
        recyclerView.layoutManager = linearLayoutManager
        val add_new_btn: Button = findViewById(R.id.add_btn)
        add_new_btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                setContentView(R.layout.add_new)
            }
        })
    }
}