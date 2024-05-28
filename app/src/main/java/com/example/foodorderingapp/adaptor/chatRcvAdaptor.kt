package com.example.foodorderingapp.adaptor

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.ActivityChatrecyclerViewBinding
import com.example.foodorderingapp.databinding.ActivityRcvitemsBinding
import com.example.foodorderingapp.databinding.RcvitemBinding
import com.example.foodorderingapp.model.chatdataclass

class chatRcvAdaptor(
    private val requiresContext: Context,
    private val chatdetails:ArrayList<chatdataclass>): RecyclerView.Adapter<chatRcvAdaptor.chatrecyclerViewViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chatrecyclerViewViewHolder {

        val layout=LayoutInflater.from(parent.context)
        val binding=RcvitemBinding.inflate(layout, parent,false)
        return(chatrecyclerViewViewHolder(binding))
    }
    override fun getItemCount(): Int {
        return chatdetails.size
    }
    override fun onBindViewHolder(holder: chatrecyclerViewViewHolder, position: Int) {
        val chat=chatdetails[position]
        holder.bind(chat)
    }

    class chatrecyclerViewViewHolder(private var databinding:RcvitemBinding):RecyclerView.ViewHolder(databinding.root) {

        fun bind(chat:chatdataclass){
            databinding.textView16.text=chat.message
            databinding.imageView.setImageResource(chat.img)
            databinding.txtfiledname.text=chat.name
            databinding.txtfiledtime.text=chat.time
        }
    }
    }