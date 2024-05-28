package com.example.foodorderingapp.Services

import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import org.jetbrains.annotations.Nullable
import android.media.MediaPlayer
import android.provider.Settings
import android.util.Log
import com.google.android.gms.common.api.Scope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class playMusicService : Service() {
    private lateinit var mp: MediaPlayer

    @Nullable
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mp.isLooping = true
        mp.start()
            GlobalScope.launch(Dispatchers.IO) {

                GlobalScope.launch(Dispatchers.IO) {
                    while (isActive) {  // Loop while the coroutine is active
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            val currentTime =
                                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                            println("Current time: $currentTime")
                        }
                        delay(3000) // Delay for 3 seconds
                    }
                }
                }


        return START_STICKY
    }

    @Override
    override fun onDestroy() {
        mp.stop()
        super.onDestroy()
    }
}
