package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.udacity.RecyclerViewInterface
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.shoes.ShoesFragment

class ShoesRecyclerViewAdapter(
    private val values: List<Shoe>,
    private val recyclerViewInterface: RecyclerViewInterface?,
) : RecyclerView.Adapter<ShoesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentShoesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            recyclerViewInterface,
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id.toString()
        holder.contentView.text = item.description
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentShoesBinding, recyclerViewInterface: RecyclerViewInterface?) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemBrand
        val contentView: TextView = binding.shoeItemName

        init {
            binding.root.setOnClickListener(
                View.OnClickListener {
                    if (recyclerViewInterface != null) {
                        val pos = adapterPosition
                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClicked(pos)

                            // Navigate to the shoe details fragment
                            val options = navOptions {
                                anim {
                                    enter = R.anim.slide_in_right
                                    exit = R.anim.slide_out_left
                                    popEnter = R.anim.slide_in_left
                                    popExit = R.anim.slide_out_right
                                }
                            }
                            // not a good way to do this, and doesn't work
                            findNavController(ShoesFragment()).navigate(R.id.action_shoesFragment_to_shoeDetailsFragment, null, options)
                        }
                    }
                },
            )
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
