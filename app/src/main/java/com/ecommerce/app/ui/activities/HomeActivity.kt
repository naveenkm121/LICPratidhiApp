package com.ecommerce.app.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ecommerce.app.R
import com.ecommerce.app.databinding.ActivityHomeBinding

import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.autoCleared
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

   // private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        navController = findNavController(R.id.nav_host_fragment_content_main)
        drawerLayout=binding.drawerLayout
        navView=binding.navView



       /* appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )*/
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

        /*navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                // Handle other item clicks
                else -> false
            }
        }*/


       // setNavigationDrawer()
       // viewModel.getCategories("hello")
      //  setupObservers()


        bottomNavigationListerner()
    }

    private fun setNavigationDrawer(){
        val menu: Menu = navView.getMenu()
        for (i in 1..3) {
            menu.add("Runtime item $i")
            val subMenu = menu.addSubMenu("SubMenu Title")
            for (i in 1..2) {
                subMenu.add("SubMenu Item $i")
            }
        }


    }

    private fun bottomNavigationListerner()
    {
        binding.appBarMain.bottomNavigation.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        DebugHandler.log("Hello Home")
                        navController.navigate(R.id.homeFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_trending ->     {
                        DebugHandler.log("Hello navigation_trending")
                        navController.navigate(R.id.wishlistFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_categories ->    {
                        DebugHandler.log("Hello navigation_categories")
                        navController.navigate(R.id.categoryFragment)
                       // findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_account ->     {
                        DebugHandler.log("Hello navigation_trending")
                        navController.navigate(R.id.productListFragment)
                       // findNavController().navigate(R.id.action_homeFragment_to_wishlistFragment)
                        return@OnNavigationItemSelectedListener true
                    }

                }
                false
            })


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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    private fun setupObservers(){

        /*   viewModel.response.observe(this, Observer {
               when (it.status) {
                  *//* ResourceViewState.Status.SUCCESS -> {
                    //setProgressBar(false)
                    if (it.data != null && it.data.status == 1) {

                    } else
                        //Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.ERROR -> {
                    // setProgressBar(false)
                    DebugHandler.log("Error Naveen== "+it.message)
                    if (it.message?.contains("401") == true) {
                        //  Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                        //  activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };

                    } else
                       // Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.LOADING ->{
                    //  setProgressBar(true)
                }*//*
            }
        })*/

    }
}