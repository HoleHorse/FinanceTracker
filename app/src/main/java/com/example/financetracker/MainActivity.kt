package com.example.financetracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.financetracker.adapter.ActionAdapter
import com.example.financetracker.data.Datasource
import com.example.financetracker.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = Datasource().getRecent(7)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recentList.adapter = ActionAdapter(myDataset)
        binding.recentList.layoutManager = linearLayoutManager

        binding.seeAll.setOnClickListener {
            startActivity(Intent(this, SeeAllActivity::class.java))
        }

        binding.addBtn.setOnClickListener {
            startActivity(Intent(this, AddNewActivity::class.java))
        }
    }

}