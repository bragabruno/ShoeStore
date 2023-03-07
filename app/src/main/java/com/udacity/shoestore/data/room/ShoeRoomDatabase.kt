package com.udacity.shoestore.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.udacity.shoestore.models.Shoe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Shoe::class], version = 1, exportSchema = false)
abstract class ShoeRoomDatabase : RoomDatabase() {
    abstract fun shoeDao(): ShoeDao

    companion object {
        @Volatile
        private var INSTANCE: ShoeRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope,
        ): ShoeRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoeRoomDatabase::class.java,
                    "shoe_database",
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(ShoeDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        class ShoeDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.shoeDao())
                    }
                }
            }

        }

        private suspend fun populateDatabase(shoeDao: ShoeDao) {
            var shoe = Shoe(1, "Sinkers",10.0, "Adidas", "Casual", "https://www.adidas.com/us/sinkers-shoes/FV5741.html")
            var images = "https://www.adidas.com/us/sinkers-shoes/FV5741.html"
            shoeDao.deleteAll()

            shoe = Shoe(2, "Sinkers",10.0, "Adidas", "Casual", images)
            shoeDao.insert(shoe)
        }
    }
}
