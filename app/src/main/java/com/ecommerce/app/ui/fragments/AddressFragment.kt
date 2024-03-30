package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.app.R
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.data.address.AddressItem
import com.ecommerce.app.databinding.FragmentAddressBinding
import com.ecommerce.app.ui.adapters.CommonRVAdapter
import com.ecommerce.app.ui.viewmodels.AddressViewModel
import com.ecommerce.app.utils.CommonSelectItemRVListerner
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.SaveSharedPreference
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddressFragment : Fragment(), CommonSelectItemRVListerner {
    private var binding: FragmentAddressBinding by autoCleared()
    private val viewModel: AddressViewModel by viewModels()
    private lateinit var adapter: CommonRVAdapter
    private var addressItemList = ArrayList<AddressItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setHasOptionsMenu(true)
        setupRecyclerView()
        setupObservers()
        setOnClickListener()
        viewModel.getAddress(ScreenName.FRAGMENT_CATEGORY.value)
    }
    private fun setupRecyclerView() {
        adapter = CommonRVAdapter(ScreenName.FRAGMENT_ADDRESS.value,this)
        binding.recyclerView.layoutManager =  LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
    private fun setOnClickListener() {
        binding.addAddressBTN.setOnClickListener({
            findNavController().navigate(R.id.action_addressFragment_to_addAddressFragment)
        })
    }
    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceViewState.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null && it.data.status == 1) {
                        if (it.data.data.isNotEmpty()) {
                            addressItemList = it.data.data as ArrayList<AddressItem>
                            adapter.setItems(addressItemList)
                        } else {
                            //binding.noResultIV.visibility = View.VISIBLE
                            Toast.makeText(requireContext(), it.data.message, Toast.LENGTH_LONG).show()
                        }
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.ERROR -> {
                    setProgressBar(false)
                    if (it.message?.contains("401") == true) {
                        Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                        //  activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };

                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.LOADING ->{
                    setProgressBar(true)
                }
            }
        })

    }

    private fun setProgressBar(b: Boolean) {
        if (!b) {
            binding.progressBar.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.VISIBLE
        }
    }
    override fun onSelectItemRVType(selectedItem: Any) {

    }

}