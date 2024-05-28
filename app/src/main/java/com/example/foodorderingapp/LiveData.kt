package com.example.foodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.foodorderingapp.databinding.ActivityLiveDataBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LiveData : AppCompatActivity() {
    private  lateinit var databindig:ActivityLiveDataBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databindig=DataBindingUtil.setContentView(this,R.layout.activity_live_data)
         var MLD =MutableLiveData(databindig.nametxt.text.toString())

     GlobalScope.launch (Dispatchers.IO){
            while (true) {
                Log.e("Change data", "Changed Data -> ${MLD.value}", )
                delay(3000)
//            Toast.makeText(this, "changed data is ->$MLD", Toast.LENGTH_SHORT).show()
            }
            Job().join()
        }

    }

}

