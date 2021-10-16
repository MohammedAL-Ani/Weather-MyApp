package com.example.my22.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.my22.databinding.FragmentHomeBinding
import com.example.my22.ui.base.BaseFragment
import com.example.my22.ui.base.BasePresenter
import com.example.my22.util.goToFragmentWithTransition
import com.example.my22.util.onClickSearch
import com.example.weather_app.model.respone.WeatherResponse
import com.example.weather_app.util.Status


class HomeFragment : BaseFragment<FragmentHomeBinding,HomePresenter>() {
    override val LOG_TAG: String = "RedFragment"
    override val getPresenter: BasePresenter = HomePresenter()
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {

    }

    override fun callbacks() {
        binding.searchField.onClickSearch {
            binding.searchField.goToFragmentWithTransition(
                HomeFragmentDirections.actionRedFragmentToBlueFragment(it),
                FragmentNavigatorExtras(binding.searchField to "search")
              )
        }
    }





}