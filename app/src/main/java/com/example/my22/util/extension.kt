package com.example.my22.util

import android.view.View
import android.widget.EditText
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator


fun View.goToFragmentWithTransition(navDir: NavDirections, extra: FragmentNavigator.Extras) {
    Navigation.findNavController(this).navigate(navDir,extra)
}


fun EditText.onClickSearch(action : (String) -> Unit) {
    this.setOnEditorActionListener { view, _, _ ->
        if (view.text.isNotBlank()) {
            action(view.text.toString())
        }
        return@setOnEditorActionListener false
    }
}