package com.ecommerce.app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ecommerce.app.ui.fragments.SplashFragment
import com.ecommerce.app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        if (getSupportActionBar() != null) {
            getSupportActionBar()?.hide();
        }
    }
}