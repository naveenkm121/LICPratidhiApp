package com.ecommerce.app.ui.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ecommerce.app.R
import com.ecommerce.app.databinding.FragmentHomeBinding
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.autoCleared
import com.google.android.material.bottomnavigation.BottomNavigationView
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setHasOptionsMenu(true)
        //wishlistViewModel.getWishlist(null)
        DebugHandler.log("Hello Bootom")
        bottomNavigationListerner()
    }


    private fun bottomNavigationListerner()
    {


        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        DebugHandler.log("Hello Home")
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_trending ->     {
                        DebugHandler.log("Hello navigation_trending")
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_categories ->    {
                        DebugHandler.log("Hello navigation_categories")
                        findNavController().navigate(R.id.action_homeFragment_to_wishlistFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_account ->     {
                        DebugHandler.log("Hello navigation_trending")
                        return@OnNavigationItemSelectedListener true
                    }

                }
                false
            })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        //binding = null
    }


}