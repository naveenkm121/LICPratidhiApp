package com.licapps.bmmis.ui.fragments

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.databinding.FragmentWebviewBinding
import com.licapps.bmmis.ui.viewmodels.HomeViewModel
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WebViewFragment : Fragment() {

    private var binding: FragmentWebviewBinding by autoCleared()
    var firstTimeOnHome = true
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var url=  arguments?.getString(IntentConstants.WEBVIEW_URL).toString()
        binding.webView .loadUrl(url)

        setWebView()
    }

    private fun setWebView() {
        // Enable Javascript
        val webSettings: WebSettings = binding.webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.builtInZoomControls = true
        webSettings.domStorageEnabled = true



       /* binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
                super.onPageStarted(view, url, favicon)
              // binding.progressBar.visibility=View.VISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
             //   binding.progressBar.visibility=View.GONE
                // Log.d("WEBCLIENT", "onPageFinished");
            }

            override fun onReceivedError(
                view: WebView, errorCode: Int,
                description: String, failingUrl: String
            ) {
                Toast.makeText(context, "Somethings wrong", Toast.LENGTH_LONG).show()
                Timber.d("Web Error$description$errorCode")
                //mWebView.loadUrl("file:///android_asset/error-page.html");
            }
        }
      */
    }




}