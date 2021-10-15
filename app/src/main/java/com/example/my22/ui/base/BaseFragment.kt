package com.example.my22.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract  class BaseFragment<VB : ViewBinding>:Fragment() {

    abstract val LOG_TAG: String

    private lateinit var _binding: ViewBinding
    var binding: VB
        get() = _binding as VB
        set(value) = TODO()

    abstract val bindingInflater: (LayoutInflater) -> VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        callbacks()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View?{
        return bindingInflater(inflater).apply { _binding = this }.root
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        _presenter.customScope.cancel()
//    }

    abstract fun setUp()
    abstract fun callbacks()
}