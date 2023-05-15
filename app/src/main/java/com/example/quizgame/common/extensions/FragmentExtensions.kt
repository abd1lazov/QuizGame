package com.example.quizgame.common.extensions

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment

fun Fragment.setDropSpinner(list: List<Any>): ArrayAdapter<Any> = object : ArrayAdapter<Any>(
    requireActivity(),
    android.R.layout.simple_spinner_dropdown_item,
    list
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        parent.overScrollMode = View.OVER_SCROLL_NEVER
        return super.getView(position, convertView, parent)
    }
}