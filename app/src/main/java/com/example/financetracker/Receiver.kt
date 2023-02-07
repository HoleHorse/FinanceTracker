package com.example.financetracker

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class Receiver : BroadcastReceiver() {
    override fun onReceive(ctx: Context, intent: Intent) {
        val notifyIntent = Intent(ctx, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val notifyPendingIntent = PendingIntent.getActivity(
            ctx, 1, notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val notification =
            NotificationCompat.Builder(ctx, "c_id")
                .setSmallIcon(R.drawable.arrow_up_circle_svgrepo_com)
                .setContentTitle("Keep track of your finance!")
                .setContentIntent(notifyPendingIntent)
                .setAutoCancel(true)
                .setStyle(NotificationCompat.BigTextStyle()
                    .bigText("Have not seen you in a while. Don't forget to record your cash flow so you could keep track of your finances."))
                .build()

        val manager = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notification)
    }
}