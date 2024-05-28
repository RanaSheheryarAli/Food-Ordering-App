package com.example.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.foodorderingapp.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
private lateinit var databinding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding=DataBindingUtil.setContentView(this, R.layout.activity_login)
        databinding.dont.setOnClickListener{
            val intent= Intent(this,signup::class.java)
            startActivity(intent)
        }
        databinding.nextbtn2.setOnClickListener{
            val intent= Intent(this,choseLocaltion::class.java)
            startActivity(intent)
            finish()
        }
    }
}