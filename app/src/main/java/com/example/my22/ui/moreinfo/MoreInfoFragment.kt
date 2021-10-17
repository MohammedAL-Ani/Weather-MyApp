package com.example.my22.ui.moreinfo

import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.my22.databinding.FragmentMoreInfoBinding
import com.example.my22.ui.base.BaseFragment
import com.example.my22.ui.base.BasePresenter
import com.example.weather_app.model.respone.WeatherResponse
import com.example.weather_app.util.Status


class MoreInfoFragment :  BaseFragment<FragmentMoreInfoBinding, MoreInfoPresenter>(), IMoreInfoViews {
    private val args: MoreInfoFragmentArgs by navArgs()
    override val LOG_TAG: String = "MoreInfoFragment"
    override val getPresenter: BasePresenter = MoreInfoPresenter(this)
    override val bindingInflater: (LayoutInflater) -> FragmentMoreInfoBinding
        = FragmentMoreInfoBinding::inflate

    private fun search(query:String){
        presenter.getInfoAboutCity(query)
    }

    override fun setup() {
        setupTransition()
        args.querycity.also {
            binding.CityNameTv.text = it
            Log.i("hhhhhhhhhhhhhhhhhhhh" , it)
            search(it)
        }
    }

    override fun callbacks() {

    }

    private fun setupTransition() {
        sharedElementEnterTransition= TransitionInflater.from(activity).inflateTransition(android.R.transition.move)
    }


    override fun onShowMoreInfo(case: Status<WeatherResponse?>) {
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
        binding.latTv.text = response.coord?.lat.toString()
        binding.lonTv.text = response.coord?.lon.toString()
        binding.CountryTv.text = response.sys?.country
        binding.SunriseShowTv.text = response.sys?.sunrise.toString()
        binding.SunsetSohwTv.text = response.sys?.sunset.toString()
        binding.typeshowTv.text = response.sys?.type.toString()
        binding.humidityShowTv.text = response.main?.humidity.toString()
        binding.pressureSohwTv.text = response.main?.pressure.toString()
        binding.tempshowTv.text = response.main?.temp.toString()


    }


}