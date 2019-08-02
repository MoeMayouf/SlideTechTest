package com.test.sliidetest.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MainImageThumbnail(

    @SerializedName("shortURL") val shortURL: String,
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("quality") val quality: Int
)