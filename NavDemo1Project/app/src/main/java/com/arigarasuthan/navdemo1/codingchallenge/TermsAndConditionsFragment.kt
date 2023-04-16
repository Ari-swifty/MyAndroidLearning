package com.arigarasuthan.navdemo1.codingchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.arigarasuthan.navdemo1.R
import com.arigarasuthan.navdemo1.databinding.FragmentTermsAndConditionsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TermsAndConditionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TermsAndConditionsFragment : Fragment() {
    private lateinit var binding: FragmentTermsAndConditionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_terms_and_conditions,
            container,
            false
        )
        return binding.root
    }

}