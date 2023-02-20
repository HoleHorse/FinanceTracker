package com.example.financetracker

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financetracker.adapter.ActionAdapter
import com.example.financetracker.data.Datasource
import com.example.financetracker.data.Numbers
import com.example.financetracker.databinding.ActivityMainBinding
import com.example.financetracker.db.DB
import java.text.DateFormat
import java.text.NumberFormat
import java.util.*

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

        binding.analysis.setOnClickListener {
            startActivity(Intent(this, DetailedActivity::class.java))
        }

        val nums: Numbers = Datasource.getNumbers(30)
        displayData(nums.balance, nums.income, nums.spent)
    }

    private fun displayData(balance: Double, income: Double, spent: Double) {
        binding.balance.text =
            getString(R.string.balance, NumberFormat.getIntegerInstance().format(balance))
        binding.monthIncome.text =
            getString(R.string.income_num, NumberFormat.getIntegerInstance().format(income))
        binding.monthSpent.text =
            getString(R.string.spent_num, NumberFormat.getIntegerInstance().format(spent))
    }

    private fun scheduleNotification() {
        val intent = Intent(applicationContext, Receiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            1,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC,
            getTime(),
            pendingIntent
        )
    }

    private fun getTime(): Long {
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = Date()
        calendar.add(Calendar.DAY_OF_YEAR, 7)
        return calendar.timeInMillis
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel("c_id", "Reminder notification", NotificationManager.IMPORTANCE_DEFAULT)
        channel.description = "This was sent due to low activity level"
        val nManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        nManager.createNotificationChannel(channel)
    }

    override fun onStop() {
        super.onStop()
        createNotificationChannel()
        scheduleNotification()
    }
}
