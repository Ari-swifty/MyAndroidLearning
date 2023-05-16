package com.arigarasuthan.newsfeedapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.arigarasuthan.newsfeedapp.databinding.FragmentInfoBinding
import com.arigarasuthan.newsfeedapp.presentation.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var newsViewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        val args: InfoFragmentArgs by navArgs()
        val article = args.selectedArticle
        newsViewModel = (activity as MainActivity).newsViewModel
        binding.infowebView.apply {
            webViewClient = WebViewClient()
            if (article.url?.isNotEmpty() == true) {
                loadUrl(article?.url)
            }
        }

        binding.floatingActionButton.setOnClickListener {
            newsViewModel.saveNewsToDB(article)
            Snackbar.make(view,"Saved Into DB",Snackbar.LENGTH_LONG).show()
        }
    }
}