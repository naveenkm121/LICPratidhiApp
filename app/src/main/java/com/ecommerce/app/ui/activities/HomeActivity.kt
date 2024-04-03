package com.ecommerce.app.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.MenuProvider
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ecommerce.app.R
import com.ecommerce.app.databinding.ActivityHomeBinding
import com.ecommerce.app.utils.DebugHandler
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        navController = findNavController(R.id.nav_host_fragment_content_main)
        drawerLayout = binding.drawerLayout
        navView = binding.navView

        appBarConfiguration = AppBarConfiguration(
            setOf(
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        setupMenuOption()
        bottomNavigationListerner()
    }



    private fun bottomNavigationListerner() {
        binding.appBarMain.bottomNavigation.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        navController.navigate(R.id.homeFragment)
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.navigation_trending -> {
                        launchWishlistScreen()
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.navigation_categories -> {
                        navController.navigate(R.id.categoryFragment)
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.navigation_account -> {
                        showBottomNavigationBar(false)
                        navController.navigate(R.id.addressFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    else-> false
                }
            })
    }


    fun showBottomNavigationBar(isVisible:Boolean) {
        binding.appBarMain.bottomNavigation.visibility = if(isVisible) View.VISIBLE else View.GONE
    }



    private fun setupMenuOption() {

        addMenuProvider(object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(com.ecommerce.app.R.menu.main, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {

           /*         android.R.id.home -> {
                        // Handle back arrow button press here
                        DebugHandler.log("Hello Back Button")
                        removeFragmentFromStack()
                        return true
                    }*/

                    R.id.action_search -> {
                        DebugHandler.log("Hello Activity Search")
                        true
                    }
                    R.id.action_wishlist -> {
                        launchWishlistScreen()
                        true
                    }
                    R.id.action_cart -> {
                        launchWishlistScreen()
                        true
                    }
                    else -> false
                }
            }

        })
    }

    private fun launchWishlistScreen(){
        showBottomNavigationBar(false)
        navController.navigate(R.id.wishlistFragment)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            DebugHandler.log("Hello HomeItem")
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        showBottomNavigationBar(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun removeFragmentFromStack() {
        // Get the FragmentManager
        val fragmentManager = supportFragmentManager

        // Check if there are any fragments in the back stack
        if (fragmentManager.backStackEntryCount > 0) {
            // Pop the last fragment from the back stack
            fragmentManager.popBackStack()
        } else {
            // If there are no fragments in the back stack, finish the activity
            finish()
        }
    }



}