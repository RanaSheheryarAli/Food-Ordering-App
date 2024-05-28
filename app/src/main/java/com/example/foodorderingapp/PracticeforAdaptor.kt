package com.example.foodorderingapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.adaptor.rcvadaptor
import com.example.foodorderingapp.databinding.ActivityPracticeforAdaptorBinding
import com.example.foodorderingapp.model.personinfo

class PracticeforAdaptor : AppCompatActivity() {
    private lateinit var databinding:ActivityPracticeforAdaptorBinding
    private lateinit var  persondata:ArrayList<personinfo>
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      databinding=DataBindingUtil.setContentView(this,R.layout.activity_practicefor_adaptor)

        persondata=ArrayList()
        persondata.add(personinfo("Sheheryar Ali","FA21-BSE-079","B"))
        persondata.add(personinfo("Ali Raza","FA21-BSE-099","B"))
        persondata.add(personinfo("M Mohsin","FA21-BSE-071","B"))
        persondata.add(personinfo("Moiz","FA21-BSE-084","B"))
        persondata.add(personinfo("Haseeb","FA21-BSE-060","B"))

        databinding.recyclerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
//        databinding.recyclerview.adapter=rcvadaptor(this,persondata)

    }
}