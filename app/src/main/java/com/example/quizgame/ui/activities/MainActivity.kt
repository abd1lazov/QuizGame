package com.example.quizgame.ui.activities

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.quizgame.R
import com.example.quizgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_history,
                R.id.navigation_settings,
                R.id.fragmentGame
            )
        )

        val listWithoutAppBar = setOf(
            R.id.navigation_home,
            R.id.navigation_history,
            R.id.navigation_settings,
            R.id.fragmentGame
        )

        val listWithoutBottomNav = setOf(R.id.fragmentGame)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (listWithoutBottomNav.contains(destination.id)) {
                navView.visibility = View.GONE
            } else {
                navView.visibility = View.VISIBLE
            }
            if (listWithoutAppBar.contains(destination.id)) {
                supportActionBar?.hide()
            } else
                supportActionBar?.show()
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}