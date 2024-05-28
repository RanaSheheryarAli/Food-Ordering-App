package com.example.foodorderingapp.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.ActivityRcvitemsBinding
import com.example.foodorderingapp.model.personinfo

class rcvadaptor(
    private val requiresContext: Context,
    private val persondeltails: ArrayList<personinfo>
) : RecyclerView.Adapter<rcvadaptor.PracticeAdaptorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeAdaptorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityRcvitemsBinding.inflate(layoutInflater, parent, false)
        return PracticeAdaptorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return persondeltails.size
    }

    override fun onBindViewHolder(holder: PracticeAdaptorViewHolder, position: Int) {
        val person = persondeltails[position]
        holder.bind(person)
    }

    class PracticeAdaptorViewHolder(
        private val databinding: ActivityRcvitemsBinding
    ) : RecyclerView.ViewHolder(databinding.root) {
        fun bind(person: personinfo) {
//            databinding.txtfiledname.text = person.name
//            databinding.txtfiledroll.text = person.roll
//            databinding.txtfiledsection.text = person.section
        }
    }
}
