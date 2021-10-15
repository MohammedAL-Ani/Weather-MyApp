package com.example.my22.ui.details

import android.view.LayoutInflater
import com.example.my22.databinding.FragmentBlueBinding
import com.example.my22.ui.base.BaseFragment


class DetailsFragment : BaseFragment<FragmentBlueBinding>(){
    override val LOG_TAG: String = "BlueFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentBlueBinding
       = FragmentBlueBinding::inflate

    override fun setUp() {

    }

    override fun callbacks() {

    }

}