package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adaptor.popularadaptor
import com.example.foodorderingapp.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private lateinit var databinding:FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        return databinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imglist=ArrayList<SlideModel>()
        imglist.add(SlideModel(R.drawable.banner3 ,ScaleTypes.FIT))
        imglist.add(SlideModel(R.drawable.banner2 ,ScaleTypes.FIT))
        imglist.add(SlideModel(R.drawable.banner1 ,ScaleTypes.FIT))

        val imgslider=databinding.imageSlider

        imgslider.setImageList(imglist,ScaleTypes.FIT)
        var popularfoodname= listOf<String>("Salate","Sandwich","Momos","Burger","Sikh Kabab","chaomis")
        val popularprice= listOf<String>("$6","$7","$9","$3","$10","$90")
        val poularimages= listOf(R.drawable.salate,R.drawable.sikh_kabab,R.drawable.salate,R.drawable.sikh_kabab,R.drawable.salate,R.drawable.sikh_kabab)
        val adaptor = popularadaptor(popularfoodname, popularprice,poularimages)
        databinding.popularrecyclerview.layoutManager=LinearLayoutManager(requireContext())
        databinding.popularrecyclerview.adapter=adaptor
    }

    companion object {

    }
}