package com.example.my22.ui

import android.view.LayoutInflater
import com.example.my22.databinding.FragmentRedBinding


class RedFragment : BaseFragment<FragmentRedBinding>() {
    override val LOG_TAG: String = "RedFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentRedBinding
      = FragmentRedBinding::inflate

    override fun setUp() {

    }

    override fun callbacks() {

    }

}