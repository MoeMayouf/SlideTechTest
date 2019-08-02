package com.test.sliidetest.presentation.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.sliidetest.data.model.Content
import kotlinx.android.synthetic.main.row.view.*

class TextViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view: View = v
    private var content: Content? = null

    fun bindItem(content: Content) {
        this.content = content

        Picasso.get().load(content.images.mainImage.url).into(view.itemImage)

        view.itemDate.text = content.title
        view.itemDescription.text = content.summary
    }
}