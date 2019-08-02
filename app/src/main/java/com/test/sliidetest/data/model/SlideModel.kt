package com.test.sliidetest.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SlideModel(

    @SerializedName("totalItems") val totalItems: Int,
    @SerializedName("content") val content: List<Content>
)