package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.ui.login.LoginFragment
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<LoginFragment>(R.id.container)
            }
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(
            R.menu.overflow_menu,
            menu,
        )
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item!!,
            findNavController(this, R.id.container),
        ) ||
            super.onOptionsItemSelected(item)
    }
}
