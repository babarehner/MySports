package com.babarehner.mysports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // can only have one nav_host_fragment ???
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as
                NavHostFragment
        val navController = navHostFragment.navController

        // Create top level destinations and add them to bottom navigation
        appBarConfiguration = AppBarConfiguration(setOf(
                        R.id.nav_home,
                        R.id.nav_account,
                        R.id.nav_profile,
                        R.id.nav_my_sports))

        setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<BottomNavigationView>(R.id.nav_view)?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)  || super.onSupportNavigateUp()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.my_sports_nav_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem) :Boolean {
//        super.onOptionsItemSelected(item)
//        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
//    }
}