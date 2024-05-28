package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adaptor.cartrcvadaptor
import com.example.foodorderingapp.adaptor.chatRcvAdaptor
import com.example.foodorderingapp.databinding.FragmentCartBinding
import com.example.foodorderingapp.model.cartdata


class CartFragment : Fragment() {
    private lateinit var databinding:FragmentCartBinding
    private lateinit var cart:ArrayList<cartdata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding=DataBindingUtil.inflate(inflater,R.layout.fragment_cart,container,false)

        cart= ArrayList()
        cart.add(cartdata("sikh kabab",R.drawable.sikh_kabab,3,"$5"))
        cart.add(cartdata("salate",R.drawable.salate,        1,"$4"))
        cart.add(cartdata("sikh kabab",R.drawable.sikh_kabab,2,"$5"))
        cart.add(cartdata("Nodelse",R.drawable.salate,       1,"$6"))
        cart.add(cartdata("sikh kabab",R.drawable.sikh_kabab,5,"$5"))
        cart.add(cartdata("Momos",R.drawable.salate,         1,"$5"))
        cart.add(cartdata("sikh kabab",R.drawable.sikh_kabab,2,"$5"))

        databinding.recyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        databinding.recyclerview.adapter = cartrcvadaptor(requireContext(), cart)


        return databinding.root
    }

    companion object {


    }
}