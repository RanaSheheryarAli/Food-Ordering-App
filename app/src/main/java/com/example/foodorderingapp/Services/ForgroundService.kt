package com.example.foodorderingapp.Services

import android.app.Service
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.foodorderingapp.model.personinfo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.*
class ForegroundService : Service() {
    private val db = FirebaseFirestore.getInstance()
    private val NOTIFICATION_ID = 1
    private val CHANNEL_ID = "100"
    private var isDestroyed = false
    private val serviceScope = CoroutineScope(Dispatchers.Default + Job())
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service start...", Toast.LENGTH_SHORT).show()
        doTask()
        return START_STICKY
    }
    private fun doTask() {
        serviceScope.launch {
            backgroundTask()
        }
    }

    private suspend fun backgroundTask() {
        while (!isDestroyed) {
            val currentTime = getCurrentTime()
            val person = personinfo(name = "Sheheryar Ali", roll = "79", section = "B", time = currentTime)
            withContext(Dispatchers.Main) {
                updateNotification("Current time: $currentTime")
                savePersonInfo(person)
            }
            delay(5000)
        }
    }
    private suspend fun savePersonInfo(person: personinfo) {
           var name=person.name
            db.collection("person").document("$name").set(person).await()
            Toast.makeText(applicationContext, "Successfully added", Toast.LENGTH_SHORT).show()
    }
    private fun updateNotification(data: String) {
        val notification = showNotification(data)
        if (notification != null) {
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }
    override fun onCreate() {
        super.onCreate()

        // Check if the service should start after device reboot
        val preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val isServiceEnabled = preferences.getBoolean("serviceEnabled", false)
        if (isServiceEnabled) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(Intent(this, ForegroundService::class.java))
            } else {
                startService(Intent(this, ForegroundService::class.java))
            }
        }
    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, "Foreground Notification",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel for foreground service notifications"
            }
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    private fun showNotification(text: String): Notification? {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText(text)
            .setSmallIcon(android.R.drawable.ic_dialog_info) // Use an appropriate icon
            .setOnlyAlertOnce(true)
            .setOngoing(true)
            .build()
    }
    private fun getCurrentTime(): String {
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return dateFormat.format(Date())
    }
    override fun onDestroy() {
        super.onDestroy()
        isDestroyed = true
        serviceScope.cancel() // Cancel the coroutine scope to stop background tasks
        Toast.makeText(this, "Stopping service", Toast.LENGTH_SHORT).show()
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
