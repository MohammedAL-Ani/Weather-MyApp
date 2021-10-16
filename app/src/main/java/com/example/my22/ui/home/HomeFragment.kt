package com.example.my22.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.my22.databinding.FragmentHomeBinding
import com.example.my22.ui.base.BaseFragment
import com.example.my22.util.goToFragmentWithTransition
import com.example.my22.util.onClickSearch
import com.example.weather_app.model.respone.WeatherResponse
import com.example.weather_app.util.Status


class HomeFragment : BaseFragment<FragmentHomeBinding,HomePresenter>(),IHomeViews {
    override val LOG_TAG: String = "RedFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding
      = FragmentHomeBinding::inflate

    override fun setUp() {

    }

    override fun callbacks() {
        binding.searchField.onClickSearch {
            binding.searchField.goToFragmentWithTransition(
                HomeFragmentDirections.actionHomeFragmentToSearchFragment(it),
                FragmentNavigatorExtras(binding.searchField to "search")
            )

    }

    override fun onShowCityWeather(case: Status<WeatherResponse?>) {
        when(case){
            is Status.Error -> onError(case.message)
            Status.Loading -> onLoading()
            is Status.Success -> onSuccess(case.data)
        }
    }

    private fun onError(message: String) {
        Toast.makeText(requireContext(),"ERROR $message", Toast.LENGTH_SHORT).show()
    }

    private fun onLoading() {
        Log.i("TAG","Loading")
    }

    private fun onSuccess(data: WeatherResponse?) {
        data?.let {
            bindLayout(it)
        }
    }

    private fun bindLayout(response: WeatherResponse) {
        binding.ShowResult.text = response.weather?.joinToString { it.main.toString() }
    }

}