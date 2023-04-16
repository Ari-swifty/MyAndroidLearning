package com.arigarasuthan.navdemo1.codingchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.arigarasuthan.navdemo1.R
import com.arigarasuthan.navdemo1.databinding.FragmentCcHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CCHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CCHomeFragment : Fragment() {
    private lateinit var binding: FragmentCcHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cc_home, container, false)
        binding.apply {
            ccHomeSignup.setOnClickListener { view->
                view.findNavController().navigate(R.id.action_CCHomeFragment_to_nameFragment)
            }

            ccHomeTanc.setOnClickListener { view->
                view.findNavController().navigate(R.id.action_CCHomeFragment_to_termsAndConditionsFragment)
            }
        }
        return binding.root
    }

}