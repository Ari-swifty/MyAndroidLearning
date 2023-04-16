package com.arigarasuthan.navdemo1.codingchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.arigarasuthan.navdemo1.R
import com.arigarasuthan.navdemo1.databinding.FragmentDashboardBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        binding.apply {
             ccDashName.text = arguments?.getString("user_name")
             ccDashEmail.text = arguments?.getString("user_email")
            ccDashTc.setOnClickListener { view->
                view.findNavController().navigate(R.id.action_dashboardFragment_to_termsAndConditionsFragment)
            }
        }
        return binding.root
    }

}