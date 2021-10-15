package com.example.my22.ui

import android.view.LayoutInflater
import com.example.my22.databinding.FragmentBlueBinding


class BlueFragment : BaseFragment<FragmentBlueBinding>(){
    override val LOG_TAG: String = "BlueFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentBlueBinding
       = FragmentBlueBinding::inflate

    override fun setUp() {

    }

    override fun callbacks() {

    }

}