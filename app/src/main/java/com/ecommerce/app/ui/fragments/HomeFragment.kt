package com.ecommerce.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ecommerce.app.databinding.FragmentHomeBinding
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        //val toolbar: Toolbar = root.findViewById(R.id.toolbar)
        return binding.root

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  bottomNavigationListener()
    }

    private fun bottomNavigationListener(){

        binding.bottomNavigation.setOnClickListener(View.OnClickListener {


               DebugHandler.log("Hello BottomNavb")
        })



    }

}