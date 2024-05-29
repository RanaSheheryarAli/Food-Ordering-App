package com.example.foodorderingapp.Services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Toast.makeText(context, "Boot completed, starting service...", Toast.LENGTH_SHORT).show()
            val serviceIntent = Intent(context, ForegroundService::class.java)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent)
            } else {
                Toast.makeText(context, "Boot is not completed,So service is not start yet...", Toast.LENGTH_SHORT).show()
                context.startService(serviceIntent)
            }
        }
    }
}
