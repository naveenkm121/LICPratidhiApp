package com.licapps.bmmis.ui.activities

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.databinding.ActivityNewHomeBinding
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.SaveSharedPreference
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewHomeActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var  navView: NavigationView
     var branch: String = ""
     var accessToken: String = ""
    protected var progressDialog: Dialog? = null
    private lateinit var binding: ActivityNewHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
        branch = SaveSharedPreference.getUserDetails(baseContext)?.branch.toString()
        accessToken = SaveSharedPreference.getUserDetails(baseContext)?.token.toString()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



        navView.setNavigationItemSelectedListener { menuItem -> // set item as selected to persist highlight
            menuItem.isChecked = true
            when (menuItem.itemId) {
                R.id.action_homeFragment_to_contact_us_Fragment -> {
                    navController.navigate(R.id.action_homeFragment_to_contact_us_Fragment)
                }

                R.id.action_rate_us -> {
                    CommonUtility.launchPlayStore(this, AppConstants.APP_PACKAGE_NAME)
                }

                R.id.action_share -> {
                    CommonUtility.shareApp(this)
                }

                R.id.action_logout -> {
                    logout()
                    finish()
                }


            }
            // close drawer when item is tapped
            drawerLayout.closeDrawers()
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here
            true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.new_home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else
            super.onBackPressed()
    }

    fun showProgressDialog(msg: String?, isCancelable: Boolean) {
        if (progressDialog == null) progressDialog = ProgressDialog(this)
        (progressDialog as ProgressDialog).setMessage(msg)
        progressDialog!!.setCancelable(isCancelable)
        (progressDialog as ProgressDialog).isIndeterminate = true
        (progressDialog as ProgressDialog).show()
    }

    fun hideProgressDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    }

    override fun onCreatePanelMenu(featureId: Int, menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_home, menu)
        setPanelUI()
        return true
    }

    private fun setPanelUI() {
        var user=SaveSharedPreference.getUserDetails(this)
        val headerView = navView.getHeaderView(0)
        val nameTV = headerView.findViewById<TextView>(R.id.nameTV)
        val desgTV = headerView.findViewById<TextView>(R.id.desgTV)
        val branchTV = headerView.findViewById<TextView>(R.id.branchTV)


        nameTV.text = user?.name
        desgTV.text = user?.designation
        branchTV.text = user?.branch
        /*
        navView.nameTV.text = user?.name
        nav_view.desgTV.text = user?.designation
        nav_view.branchTV.text = user?.branch*/
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout()
                finish()
                true
            }
            R.id.action_home -> {
                //  navController.popBackStack(R.id.homeFragment,false)
                true
            }
            R.id.action_share -> {
                CommonUtility.shareApp(this)
                //  navController.popBackStack(R.id.homeFragment,false)
                true
            }
            /* R.id.action_contact -> {
                 //  navController.popBackStack(R.id.homeFragment,false)
                 navController.navigate(R.id.action_homeFragment_to_contact_us_Fragment)
                 true
             }*/

            else -> super.onOptionsItemSelected(item)
        }
    }


    fun logout() {
        SaveSharedPreference.logout(this)
    }


}