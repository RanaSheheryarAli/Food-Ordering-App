package com.example.foodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.adaptor.chatRcvAdaptor
import com.example.foodorderingapp.databinding.ActivityChatrecyclerViewBinding
import com.example.foodorderingapp.databinding.ActivityRcvitemsBinding
import com.example.foodorderingapp.model.chatdataclass

class chatrecyclerView : AppCompatActivity() {
    private lateinit var databinding:ActivityChatrecyclerViewBinding

    private lateinit var chat:ArrayList<chatdataclass>



    private lateinit var ab:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       databinding=DataBindingUtil.setContentView(this,R.layout.activity_chatrecycler_view)

        chat=ArrayList()

        chat.add(chatdataclass(R.drawable.profile,"Sherry","3:20","Hello Assignment kar li"))
        chat.add(chatdataclass( R.drawable.profile,"Ali","12:45", "DLD k kiya km ha"))
        chat.add(chatdataclass( R.drawable.profile,"Mohsin","8:50","App k Quiz  ata ha ap ko"))
        chat.add(chatdataclass( R.drawable.profile,"Api","10:20","kal Pizza Khana ha ok"))
        chat.add(chatdataclass( R.drawable.profile,"Moiz","6:20","tor ja tor ja"))
        chat.add(chatdataclass( R.drawable.profile,"Haseeb","7:33","pubg khalay?"))
        chat.add(chatdataclass(R.drawable.profile,"Sherry","3:20","kal saray lecture ha"))
        chat.add(chatdataclass( R.drawable.profile,"Ali","12:45","yar pkg ni maray pass"))
        chat.add(chatdataclass( R.drawable.profile,"Mohsin","8:50","moiz ny km aba ha"))
        chat.add(chatdataclass( R.drawable.profile,"Api","10:20","sabzi ly ana"))
        chat.add(chatdataclass( R.drawable.profile,"Moiz","6:20","Masti karraya ha baz aa ja"))
        chat.add(chatdataclass( R.drawable.profile,"Haseeb","7:33","Hello ki karda wa"))



        databinding.recyclerviewid.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        databinding.recyclerviewid.adapter=chatRcvAdaptor(this, chat)

    }
}

