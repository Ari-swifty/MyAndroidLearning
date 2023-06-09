package com.arigarasuthan.navdemo1.codingchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.arigarasuthan.navdemo1.R
import com.arigarasuthan.navdemo1.databinding.FragmentEmailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [EmailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        binding.apply {
            ccSubmitButton.setOnClickListener { view->
                if(ccEmailEdittext.text.isNotEmpty())
                {
                    val bundle = bundleOf(
                        "user_email" to ccEmailEdittext.text.toString(),
                        "user_name" to arguments?.getString("user_name")
                    )
                    view.findNavController().navigate(R.id.action_emailFragment_to_dashboardFragment,bundle)
                }
            }
        }
        return binding.root
    }

}