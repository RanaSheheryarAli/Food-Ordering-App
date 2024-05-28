package com.example.foodorderingapp.adaptor
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.CartitemsBinding
import com.example.foodorderingapp.model.cartdata
class cartrcvadaptor(private  val requirsContext: Context,
                     private val cart:ArrayList<cartdata>):RecyclerView.Adapter<cartrcvadaptor.cartrcvadaptorViewHolder>(){
    class cartrcvadaptorViewHolder(private  val binding:CartitemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cart: cartdata) {
            binding.name.text=cart.name
            binding.img.setImageResource(cart.img)
            binding.quantity.text=cart.quantity.toString()
            binding.price.text=cart.price
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartrcvadaptor.cartrcvadaptorViewHolder {
    val layout=LayoutInflater.from(parent.context)
        val binding=CartitemsBinding.inflate(layout,parent,false)
        return cartrcvadaptorViewHolder(binding)
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: cartrcvadaptor.cartrcvadaptorViewHolder, position: Int) {
      val cart= this.cart[position]
        holder.bind(cart)
    }
    override fun getItemCount(): Int {
       return cart.size
    }
    }
