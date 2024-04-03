package com.ecommerce.app.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.app.R
import com.ecommerce.app.databinding.ActivityHomeBinding
import com.ecommerce.app.databinding.ActivityLaunchBinding
import com.ecommerce.app.utils.DebugHandler
import com.google.firebase.messaging.FirebaseMessaging
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
    private fun fcmToken() {
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    DebugHandler.log("Fetching FCM registration token failed" + task.exception)
                    return@addOnCompleteListener
                }
                val token = task.result
                //to showing
                //binding!!.token.setText(token)
                Toast.makeText(this, "get a token", Toast.LENGTH_SHORT).show()
            }
    }

}