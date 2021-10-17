package com.example.my22.ui.details

import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.navArgs

import com.example.my22.databinding.FragmentDetailsBinding
import com.example.my22.ui.base.BaseFragment
import com.example.my22.ui.base.BasePresenter
import com.example.my22.util.goToFragmentWithTransition
import com.example.weather_app.model.respone.WeatherResponse
import com.example.weather_app.util.Status


class DetailsFragment : BaseFragment<FragmentDetailsBinding,DetailsPresenter>(),IDetailsViews{
    private val args:DetailsFragmentArgs by navArgs()
    override val LOG_TAG: String = "BlueFragment"
    override val getPresenter: BasePresenter = DetailsPresenter(this)
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding
       = FragmentDetailsBinding::inflate

    private fun search(query:String){
        presenter.getCityName(query)
    }

    override fun setup() {
        setupTransition()
        args.query.also {
            binding.searchField1.setText(it)
            search(it)
        }
        passToFragmentInfo()
    }

    override fun callbacks() {

    }


    private fun setupTransition() {
        sharedElementEnterTransition= TransitionInflater.from(activity).inflateTransition(android.R.transition.move)
    }

    override fun onShowCityWeather(case: Status<WeatherResponse?>) {
        when (case) {
            is Status.Error -> onError(case.message)
            Status.Loading -> onLoading()
            is Status.Success -> onSuccess(case.data)
        }
    }

    private fun onError(message: String) {
        Toast.makeText(requireContext(), "ERROR $message", Toast.LENGTH_SHORT).show()
    }

    private fun onLoading() {
        Log.i("TAG", "Loading")
    }

    private fun onSuccess(data: WeatherResponse?) {
        data?.let {
            bindLayout(it)
        }
    }

    private fun bindLayout(response: WeatherResponse) {
        binding.iconTv.text = response.weather?.joinToString { it.icon.toString() }
        binding.CaseWeatherTV.text = response.weather?.joinToString { it.description.toString() }
        binding.CityNameTv.text = response.name

    }

    private fun passToFragmentInfo(){
        binding.CityNameTv.setOnClickListener {
            it.goToFragmentWithTransition(
                DetailsFragmentDirections.actionBlueFragmentToMoreInfoFragment(binding.CityNameTv.text as String),
                FragmentNavigatorExtras(binding.CityNameTv to "cityname")
            )
        }
    }



}