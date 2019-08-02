package com.test.sliidetest.presentation.viewholder

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso
import com.test.sliidetest.R
import com.test.sliidetest.data.model.Content

class CustomPagerAdapter(list: List<Content>?, private val mContext: Context) : PagerAdapter() {

    private val mInflater: LayoutInflater

    private val mPagerList = ArrayList<Content>()

    init {

        if (list != null && list.isNotEmpty())
            mPagerList.addAll(list)

        this.mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val rootView = mInflater.inflate(R.layout.item_pager, container, false)

        val holder = ViewHolder(rootView)

        val data = mPagerList[position]

        holder.pagerText.text = data.title
        Picasso.get().load(data.images.mainImage.url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageView)
        container.addView(rootView)

        return rootView
    }

    override fun getCount(): Int {
        Log.d("SIZE", mPagerList.size.toString())
        return mPagerList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // Don't call the super
        // super.destroyItem(container, position, object);

        container.removeView(`object` as View)
    }

    internal inner class ViewHolder(rootView: View) {

        var pagerText: TextView = rootView.findViewById(R.id.tvPager)
        var imageView: ImageView = rootView.findViewById(R.id.imageViewViewpager)

    }
}