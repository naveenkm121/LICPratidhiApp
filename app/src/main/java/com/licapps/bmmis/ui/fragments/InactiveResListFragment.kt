package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.inactive.InactiveDOCLIA
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.prospectives.Prospective
import com.licapps.bmmis.databinding.FragmentMabDetailsBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.CasesListAdapter
import com.licapps.bmmis.ui.viewmodels.InactiveResListViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class InactiveResListFragment : Fragment(), CasesListAdapter.CasesListItemListener {

    private var binding: FragmentMabDetailsBinding by autoCleared()
    private val viewModel: InactiveResListViewModel by viewModels()
    private lateinit var adapter: CasesListAdapter
    private lateinit var screenToShow: String
    private lateinit var requestType: String

    private var inactiveList = ArrayList<InactiveDOCLIA>()
    private val apiRequest = CommonReq()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMabDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apiRequest.branch = (activity as NewHomeActivity).branch
        screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        requestType = arguments?.getString(IntentConstants.REQ_INACTIVE_TYPE_SCREEN).toString()
        setupRecyclerView()
        setupObservers()
        Timber.d("ScreenToshow:"+screenToShow +"requestType ::"+requestType)
        viewModel.getInactiveResList(apiRequest, screenToShow,requestType)
      //  Timber.d("ScreenToshow:"+screenToShow +"requestType ::"+requestType)

    }


    private fun setupRecyclerView() {
        adapter = CasesListAdapter(this, screenToShow)
        binding.mabRV.layoutManager = LinearLayoutManager(requireContext())
        binding.mabRV.adapter = adapter
    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null) {
                        if (it.data.data.isNotEmpty()) {
                            // binding.progressBar.visibility = View.GONE
                            inactiveList = it.data.data as ArrayList<InactiveDOCLIA>
                            adapter.setItems(inactiveList)

                        } else {
                            binding.noResultIV.visibility = View.VISIBLE

                        }
                    } else
                        Toast.makeText(
                            requireContext(),
                            R.string.err_in_response,
                            Toast.LENGTH_SHORT
                        ).show()

                }
                Resource.Status.ERROR ->{
                    setProgressBar(false)
                    if(it.message?.contains("401")==true){
                        Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                        activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };
                    }
                    else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }


                Resource.Status.LOADING ->
                   setProgressBar(true)
            }
        })

    }

    override fun onClickedListItem(case: Prospective) {
    }






    private fun setProgressBar(b: Boolean) {
        if(!b){
            binding.progressBarShim.shimmerLayout.visibility = View.GONE
            binding.progressBarShim.shimmerLayout.showShimmer(false)
        }
        else
        {
            binding.progressBarShim.shimmerLayout.visibility = View.VISIBLE
            binding.progressBarShim.shimmerLayout.showShimmer(true)
        }
    }


}
