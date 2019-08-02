package com.test.sliidetest.presentation.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.test.sliidetest.R
import com.test.sliidetest.common.utils.SquareViewPager

class PagerItemHolder(view: View) : RecyclerView.ViewHolder(view) {

    var viewPager: SquareViewPager

    init {

        viewPager = view.findViewById(R.id.slidesPager)
    }
}