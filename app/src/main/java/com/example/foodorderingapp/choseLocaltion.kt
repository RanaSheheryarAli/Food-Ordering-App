package com.example.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import com.example.foodorderingapp.databinding.ActivityChoseLocaltionBinding
import java.lang.reflect.Array

class choseLocaltion : AppCompatActivity() {
    private  lateinit var databinding:ActivityChoseLocaltionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       databinding=DataBindingUtil.setContentView(this,R.layout.activity_chose_localtion)
        val locationlist= arrayListOf<String>("Arifwala","Sahiwal","Pakpatan","Okara")
        val adaptor=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationlist)
        val autocompletetextview: AutoCompleteTextView = databinding.locationlist
        autocompletetextview.setAdapter(adaptor)
        databinding.locNextBtn.setOnClickListener{
            var intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}