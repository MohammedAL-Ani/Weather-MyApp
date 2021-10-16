package com.example.my22.ui.details

import android.view.LayoutInflater

import com.example.my22.databinding.FragmentDetailsBinding
import com.example.my22.ui.base.BaseFragment


class DetailsFragment : BaseFragment<FragmentDetailsBinding,DetailsPresenter>(),IDetailsViews{
    override val LOG_TAG: String = "BlueFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding
       = FragmentDetailsBinding::inflate

    override fun setUp() {

    }

    override fun callbacks() {

    }

}