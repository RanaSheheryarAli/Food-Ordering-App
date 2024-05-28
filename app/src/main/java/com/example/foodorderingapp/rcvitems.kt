package com.example.foodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.adaptor.rcvadaptor
import com.example.foodorderingapp.databinding.ActivityPracticeforAdaptorBinding
import com.example.foodorderingapp.databinding.ActivityRcvitemsBinding
import com.example.foodorderingapp.model.personinfo

class rcvitems : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_rcvitems)



    }
}