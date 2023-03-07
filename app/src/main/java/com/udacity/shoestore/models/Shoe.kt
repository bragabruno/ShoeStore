package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "shoe_table")
data class Shoe(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: String
) : Parcelable {
    override fun toString(): String {

        if (id == null) id = 0
        return "Shoe(id='$id, name='$name', size=$size, company='$company', description='$description', images='$images')"
    }
}
