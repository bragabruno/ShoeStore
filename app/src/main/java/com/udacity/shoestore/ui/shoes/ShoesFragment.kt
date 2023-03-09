package com.udacity.shoestore.ui.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udacity.RecyclerViewInterface
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoesRecyclerViewAdapter
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ShoesFragment : Fragment(), RecyclerViewInterface, ShoesRecyclerViewAdapter.ItemClickListener {

    private lateinit var binding: FragmentShoesBinding

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        binding = FragmentShoesBinding.inflate(layoutInflater)

        binding.root

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentShoesBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_shoes_list, container, false)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = ShoesRecyclerViewAdapter(PlaceholderContent.ITEMS, this@ShoesFragment)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ShoesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onItemClicked(position: Int) {
        onDestroy()
    }

    override fun onItemClick(view: View?, position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.action_shoesFragment_to_shoeDetailsFragment)
    }
}
