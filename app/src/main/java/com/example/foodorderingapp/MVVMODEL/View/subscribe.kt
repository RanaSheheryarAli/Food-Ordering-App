package com.example.foodorderingapp.MVVMODEL.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.foodorderingapp.MVVMODEL.Viewmodel.subscribeViewmodel
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.ActivityServicektBinding
import com.example.foodorderingapp.databinding.ActivitySubscribeBinding

class subscribe : AppCompatActivity() {
    private lateinit var binding: ActivitySubscribeBinding
    private lateinit var viewmodel:subscribeViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_subscribe)
        viewmodel=ViewModelProvider(this).get(subscribeViewmodel::class.java)

        viewmodel.txt.observe(this){
            binding.txtfield.text=it.toString()
        }
        viewmodel.btntxt.observe(this) {
            binding.subbtn.text = it.toString()
        }
        binding.subbtn.setOnClickListener{
            viewmodel.update()
        }
    }
}