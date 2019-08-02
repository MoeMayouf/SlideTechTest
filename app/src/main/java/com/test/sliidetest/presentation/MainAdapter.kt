package com.test.sliidetest.presentation

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.sliidetest.R
import com.test.sliidetest.common.inflate
import com.test.sliidetest.data.model.Content
import com.test.sliidetest.data.model.SlideModel
import com.test.sliidetest.presentation.viewholder.CustomPagerAdapter
import com.test.sliidetest.presentation.viewholder.PagerItemHolder
import com.test.sliidetest.presentation.viewholder.TextViewHolder


class MainAdapter(private val slideModel: SlideModel, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var inflatedView: View
    private var count: Int = 0

    private val mViewPageStates = HashMap<Int, Int>()
    private val mPagerList = ArrayList<Content>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val viewHolder: RecyclerView.ViewHolder?

        Log.d("VIEWTYPE", "BLAH")

        if (viewType == VIEW_TYPE_PAGER) {
            inflatedView = parent.inflate(R.layout.item_recycler_pager, false)
            viewHolder = PagerItemHolder(inflatedView)
            Log.d("TYPE", "PAGER")

        } else {
            inflatedView = parent.inflate(R.layout.row, false)
            viewHolder = TextViewHolder(inflatedView)
            Log.d("TYPE", "RECYCLER")
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        Log.d("ITEMSIZE", slideModel.content.size.toString())
        return slideModel.content.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("COUNT", count.toString())
        Log.d("COUNTPOS", position.toString())
        when (holder.itemViewType) {
            VIEW_TYPE_PAGER -> {
                val textHolder = holder as PagerItemHolder
                configurePagerHolder(textHolder, count)
                count++
            }
            else            -> {
                val pagerHolder = holder as TextViewHolder
                configureTextItem(pagerHolder, count)
                count++
            }
        }
    }

    private fun configureTextItem(holder: TextViewHolder, position: Int) {

        if (count < slideModel.content.size - 3) {
            holder.bindItem(slideModel.content[position])
        }
    }

    private fun configurePagerHolder(holder: PagerItemHolder, position: Int) {
        if (count < slideModel.content.size - 3) {
            mPagerList.add(slideModel.content[position])
            mPagerList.add(slideModel.content[position + 1])
            mPagerList.add(slideModel.content[position + 2])
            count = position + 3

            val adapter = CustomPagerAdapter(mPagerList, context)
            holder.viewPager.adapter = adapter
            mPagerList.clear()
        } else {
            return
        }
/*
        if (mViewPageStates.containsKey(position)) {
            holder.viewPager.currentItem = mViewPageStates[position]!!
        }*/
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 4 == 0) {
            VIEW_TYPE_PAGER
        } else {
            VIEW_TYPE_RECYCLER
        }
    }


    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {

        if (holder is PagerItemHolder) {

            mViewPageStates[holder.getAdapterPosition()] = holder.viewPager.currentItem
            super.onViewRecycled(holder)
        }
    }

    companion object {

        internal const val VIEW_TYPE_PAGER = 0
        internal const val VIEW_TYPE_RECYCLER = 1
    }
}