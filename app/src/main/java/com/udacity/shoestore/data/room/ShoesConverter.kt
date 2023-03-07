package com.udacity.shoestore.data.room

import androidx.room.TypeConverter

class ShoesConverter {
    @TypeConverter
    fun fromBitmap(value: String): List<String> {
        return if (value.isEmpty()) emptyList() else value.split(",")
    }
    @TypeConverter
    fun toBitmap(list: List<String>): String {
        return if (list.isEmpty()) "" else list.joinToString(",")
    }
}