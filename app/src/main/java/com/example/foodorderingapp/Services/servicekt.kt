package com.example.foodorderingapp.Services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.ActivityServicektBinding

class servicekt : AppCompatActivity() {
    private lateinit var binding:ActivityServicektBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_servicekt)
        binding.startbtn.setOnClickListener{
            startService(Intent(this@servicekt,ForegroundService::class.java))
        }
        binding.stopbtn.setOnClickListener{
            stopService(Intent(this,ForegroundService::class.java))
        }
    }
}