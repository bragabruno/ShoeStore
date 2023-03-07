package com.udacity.shoestore.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.shoestore.models.Shoe
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoeDao {

    @Query("SELECT * FROM shoe_table ORDER BY name ASC")
    fun getAllShoes(): Flow<List<Shoe>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(shoe: Shoe)

//    @Query("DELETE FROM shoe_table")
    @Delete(entity = Shoe::class)
    suspend fun deleteAll()
}
