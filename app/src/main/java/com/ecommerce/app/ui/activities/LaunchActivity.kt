package com.ecommerce.app.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.app.R
import com.ecommerce.app.databinding.ActivityHomeBinding
import com.ecommerce.app.databinding.ActivityLaunchBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityLaunchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val navController = findNavController(R.id.nav_host_fragment)
    }


}