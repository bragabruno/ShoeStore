package com.udacity.shoestore.data.room

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ShoesApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ShoeRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ShoeRepository(database.shoeDao()) }
}
