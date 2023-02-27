package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoesBinding

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        binding.imageView.setOnClickListener {
            detailsShoe()
        }
        return binding.root
//        inflater.inflate(R.layout.fragment_shoe_detail, container, false)

    }
        fun detailsShoe() {
            NavHostFragment.findNavController(this@ShoeDetailsFragment).navigate(R.id.action_shoesFragment_to_shoeDetailFragment)
        }
}
