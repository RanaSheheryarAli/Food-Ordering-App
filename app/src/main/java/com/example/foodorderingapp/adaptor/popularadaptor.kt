package com.example.foodorderingapp.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.PopularBinding

class popularadaptor(
    private val items:List<String>,
    private val price:List<String>,
    private val image:List<Int>): RecyclerView.Adapter<popularadaptor.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
       return PopularViewHolder(PopularBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item=items[position]
        val images =image[position]
        val price=price[position]
        holder.bind(item,images,price)
    }
    class PopularViewHolder(private val databinding:PopularBinding):RecyclerView.ViewHolder(databinding.root) {

    private val imgview=databinding.imageView5

    fun bind(item:String,images:Int,price:String){
    databinding.foodnamepopular.text=item
        databinding.pricepopular.text=price
        imgview.setImageResource(images)
}
    }

}