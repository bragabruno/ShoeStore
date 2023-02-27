package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var id: String,
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {
    override fun toString(): String {
        return "Shoe(id='$id, name='$name', size=$size, company='$company', description='$description', images=$images)"
    }
}
