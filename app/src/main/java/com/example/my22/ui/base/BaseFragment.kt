package com.example.my22.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.cancel

abstract  class BaseFragment<VB : ViewBinding,P : BasePresenter>:Fragment() {

    abstract val LOG_TAG: String

    private lateinit var _binding: ViewBinding
    protected val binding
        get() = _binding as VB

     lateinit var _presenter: BasePresenter
    protected val presenter
        get() = _presenter as P


    abstract val getPresenter :BasePresenter
    abstract val bindingInflater: (LayoutInflater) -> VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        callbacks()
    }

    abstract fun setup()
    abstract fun callbacks()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View?{
        _presenter=getPresenter
        return bindingInflater(inflater).apply { _binding = this }.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _presenter.customScope.cancel()
    }


}