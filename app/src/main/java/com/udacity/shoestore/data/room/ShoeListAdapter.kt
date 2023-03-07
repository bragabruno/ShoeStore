package com.udacity.shoestore.data.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeListAdapter : ListAdapter<Shoe, ShoeListAdapter.ShoeViewHolder>(ShoeDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        return ShoeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name)
    }

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val showItemView: TextView = itemView.findViewById(R.id.shoe_item_name)

        fun bind(text: String?) {
            showItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ShoeViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_shoes, parent, false)
                return ShoeViewHolder(view)
            }
        }
    }

    companion object {
        private val ShoeDiffCallback = object : DiffUtil.ItemCallback<Shoe>() {
            override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}
