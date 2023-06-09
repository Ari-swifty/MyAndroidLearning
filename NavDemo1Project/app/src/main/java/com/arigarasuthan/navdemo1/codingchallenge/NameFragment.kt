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
import com.arigarasuthan.navdemo1.databinding.FragmentNameBinding

/**
 * A simple [Fragment] subclass.
 * Use the [NameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        binding.apply {
            ccNextButton.setOnClickListener { view ->
                if (ccNameEdittext.text.toString().isNotEmpty()) {
                    val bundle = bundleOf("user_name" to ccNameEdittext.text.toString())
                    view.findNavController()
                        .navigate(R.id.action_nameFragment_to_emailFragment, bundle)
                }
            }
        }
        return binding.root
    }

}