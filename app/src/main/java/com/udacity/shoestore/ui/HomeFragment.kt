package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHostBinding

class HomeFragment : Fragment() {
    private var binding: FragmentHostBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHostBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHostBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        binding!!.buttonNext.setOnClickListener {
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.action_hostFragment_to_loginFragment, null, options)
            onDestroy()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding!!.buttonNext.visibility = View.GONE
        binding!!.textWelcome.visibility = View.GONE
        if (isRemoving) {
            val parentFragment = parentFragment
            if (parentFragment is NavHostFragment) {
                parentFragment.childFragmentManager.beginTransaction().remove(this).commit()
            }
        }
    }

    companion object { }
}
