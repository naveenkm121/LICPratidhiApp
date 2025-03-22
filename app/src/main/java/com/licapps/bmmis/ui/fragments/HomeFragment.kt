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
class HomeFragment : Fragment(), HomeAdapter.CardItemListener {

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
        if (firstTimeOnHome) {
            firstTimeOnHome = false
            //context?.let { UICommon.showWebViewAlertDialog(it,str, R.layout.dialog_webview) }
        }

        //  setInfoText()

    }

    private fun setHomeAdapter() {
        val layoutManager = GridLayoutManager(context, 6)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    1,2,3-> 2
                    4,5,6,7,8,9,10,11,13,14,15,16->3
                    else -> 6
                }
            }
        }
        binding.recylerView.layoutManager = layoutManager

        val itemList = ArrayList<String>()
        itemList.add(ScreenName.BOC.value)
        itemList.add(ScreenName.NB_FOR_DAY.value)
        itemList.add(ScreenName.NB_FOR_MONTH.value)
        itemList.add(ScreenName.NB_UPTO_DAY.value)
        itemList.add(ScreenName.CHANNELWISE_NB.value)
        itemList.add(ScreenName.ACTIVISATION.value)
        itemList.add(ScreenName.INACTIVE_RESOURCE.value)
        //itemList.add(ScreenName.AVAILABLE_RESOURCE.value)
        itemList.add(ScreenName.RESOURCE_BUILDING.value)
        itemList.add(ScreenName.MAB.value)
        itemList.add(ScreenName.EMHR.value)
        itemList.add(ScreenName.TOP_PERFORMERS.value)
        itemList.add(ScreenName.PLANWISE_PERF.value)
        itemList.add(ScreenName.PROSPECTIVE.value)
        itemList.add(ScreenName.ANANDA.value)
        itemList.add(ScreenName.NUA.value)
        itemList.add(ScreenName.PERSISTENCY.value)
        itemList.add(ScreenName.CLAIMS.value)
        itemList.add(ScreenName.NAV_ULIP.value)


        //  itemList.add(ScreenName.ENQUIRY.value)
        val homeAdapter = HomeAdapter(itemList, this)
        binding.recylerView.adapter = homeAdapter
    }

    override fun onClickedCard(cardName: String) {
        /*findNavController().navigate(
            R.id.action_plansFragment_to_planDetailFragment,
            bundleOf("id" to cardName)
        )*/
        when {

            ScreenName.ACTIVISATION.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_activisationFragment)
            }

            ScreenName.INACTIVE_RESOURCE.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_inactiveFragment)
            }

            ScreenName.PROSPECTIVE.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_prospectiveFragment,
                   bundleOf( IntentConstants.CASES_REQ_SCREEN to ScreenName.PROSPECTIVE_FP.value))
            }

            ScreenName.TOP_PERFORMERS.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_topPerformersFragment)
            }
            ScreenName.NB_UPTO_DAY.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_nbUptoDayFragment)
            }
            ScreenName.NB_FOR_DAY.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_nbForDayFragment)
            }
            ScreenName.NB_FOR_MONTH.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_nbUptoMonthFragment)
            }
            ScreenName.CHANNELWISE_NB.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_nbChannelWiseFragment)
            }
            ScreenName.AVAILABLE_RESOURCE.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_availableResourceFragment)
            }
            ScreenName.BOC.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_bocFragment)
            }
            ScreenName.RESOURCE_BUILDING.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_resBuildingFragment)
            }

            ScreenName.MAB.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_mabFragment)
            }

            ScreenName.PLANWISE_PERF.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_planPerfFragment)
            }
            ScreenName.ANANDA.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_anandaFragment)
            }

            ScreenName.CLAIMS.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_claimsFragment)
            }

            ScreenName.PERSISTENCY.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_persistenceFragment)
            }

            ScreenName.EMHR.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_eMhrFragment)
            }

            ScreenName.NUA.value == cardName -> {
                findNavController().navigate(R.id.action_homeFragment_to_nuaFragment)
            }

            ScreenName.NAV_ULIP.value == cardName -> {
                val navUrl="https://services.licindia.in/LICEPS/portlets/visitor/CurrentNAV/CurrentNAVDay/CurrentNAVDayController.jpf"
              //  context?.let { CommonUtility.launchBrowser(it, navUrl) }
                findNavController().navigate(R.id.action_homeFragment_to_webViewFragment,
                        bundleOf(IntentConstants.WEBVIEW_URL to navUrl)
                )

            }



        }
        /* val intent = Intent(context, NewHomeActivity::class.java)
         intent.putExtra(IntentConstants.SCREEN_NAME,cardName)
         startActivity(intent);*/
    }
}