package com.test.sliidetest.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.util.*

@Keep
data class Images(

    @SerializedName("mainImage") val mainImage: MainImage,
    @SerializedName("mainImageThumbnail") val mainImageThumbnail: MainImageThumbnail,
    @SerializedName("additionalImages") val additionalImages: List<Objects>
)