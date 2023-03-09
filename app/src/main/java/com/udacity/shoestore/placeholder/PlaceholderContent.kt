package com.udacity.shoestore.placeholder

import com.udacity.shoestore.models.Shoe
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<Shoe> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, Shoe> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i: Int in 1..COUNT) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: Shoe) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id.toString(), item)
    }

    private fun createPlaceholderItem(position: Int): Shoe {
        return Shoe(position, "Jordan's " + position, 1.0, "Nike", makeDetails(position), "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.nike.com%2Ft%2Fjordan-1-mid-sh")
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
//        for (i in 0..position - 1) {
        builder.append("\nMore details information here.")
//        }
        return builder.toString()
    }

    /**
     * A placeholder item representing a piece of content.
     */
//    data class Shoe(val id: String, val content: String, val details: String) {
//        override fun toString(): String = content
//    }
}
