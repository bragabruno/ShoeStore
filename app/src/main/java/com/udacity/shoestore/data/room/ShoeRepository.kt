package com.udacity.shoestore.data.room

import androidx.annotation.WorkerThread
import com.udacity.shoestore.models.Shoe
import kotlinx.coroutines.flow.Flow

class ShoeRepository(private val shoeDao: ShoeDao) {

    val allShoes: Flow<List<Shoe>> = shoeDao.getAllShoes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(shoe: Shoe) {
        shoeDao.insert(shoe)
    }
}
