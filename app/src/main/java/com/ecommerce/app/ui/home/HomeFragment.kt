package com.ecommerce.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.databinding.FragmentHomeBinding
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding  by autoCleared()

    // This property is only valid between onCreateView and
    // onDestroyView.
  //  private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
       // val root: View = binding.root

/*        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        val apiRequest= CommonReq()

        viewModel.getPokemonData(apiRequest);


    }

   private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceViewState.Status.SUCCESS -> {
                    DebugHandler.log("Hello Success ")
                 //   DebugHandler.log("Data == ${it.data}")

                }
                ResourceViewState.Status.ERROR -> {
                    DebugHandler.log("Hello error ")
                }
                ResourceViewState.Status.LOADING ->{
                   DebugHandler.log("Hello Loading ")
                }
                   // setProgressBar(true)
            }
        })

    }


}