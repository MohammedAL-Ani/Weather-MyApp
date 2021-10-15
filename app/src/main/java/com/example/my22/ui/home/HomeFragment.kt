package com.example.my22.ui.home

import android.view.LayoutInflater
import com.example.my22.databinding.FragmentRedBinding
import com.example.my22.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentRedBinding>() {
    override val LOG_TAG: String = "RedFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentRedBinding
      = FragmentRedBinding::inflate

    override fun setUp() {

    }

    override fun callbacks() {

    }

}