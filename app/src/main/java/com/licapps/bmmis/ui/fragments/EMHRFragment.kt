package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.databinding.FragmentHomeBinding
import com.licapps.bmmis.ui.adapters.HomeAdapter
import com.licapps.bmmis.ui.viewmodels.HomeViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EMHRFragment : Fragment(), HomeAdapter.CardItemListener {

    private var binding: FragmentHomeBinding by autoCleared()
    var firstTimeOnHome = true
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHomeAdapter()

    }

    private fun setHomeAdapter() {
        val layoutManager = GridLayoutManager(context, 1)
        binding.recylerView.layoutManager = layoutManager

        val itemList = ArrayList<String>()
        itemList.add(ScreenName.EMHR_ANANDA.value)
        itemList.add(ScreenName.EMHR_DIGI_MKTG.value)
        val homeAdapter = HomeAdapter(itemList, this)
        binding.recylerView.adapter = homeAdapter
    }

    override fun onClickedCard(cardName: String) {
        /*findNavController().navigate(
            R.id.action_plansFragment_to_planDetailFragment,
            bundleOf("id" to cardName)
        )*/
        when {

            ScreenName.EMHR_ANANDA.value == cardName -> {
                CommonUtility.launchBrowser(requireContext(),AppConstants.EMHR_ANANDA_URL)
               // findNavController().navigate(R.id.action_eMhrFragment_to_ananda_emhrFragment)
            }

            ScreenName.EMHR_DIGI_MKTG.value == cardName -> {
                CommonUtility.launchBrowser(requireContext(),AppConstants.EMHR_DIRECTMKTNG_URL)
                //findNavController().navigate(R.id.action_eMhrFragment_to_webViewFragment,bundleOf(IntentConstants.WEBVIEW_URL to AppConstants.EMHR_DIRECTMKTNG_URL))
            }

        }
    }
}