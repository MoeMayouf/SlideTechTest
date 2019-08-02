package com.test.sliidetest.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Content(

    @SerializedName("contentId") val contentId: String,
    @SerializedName("title") val title: String,
    @SerializedName("summary") val summary: String,
    @SerializedName("contentSource") val contentSource: String,
    @SerializedName("contentSourceDisplay") val contentSourceDisplay: String,
    @SerializedName("contentSourceLogo") val contentSourceLogo: String,
    @SerializedName("categories") val categories: List<String>,
    @SerializedName("categoriesEnglish") val categoriesEnglish: List<String>,
    @SerializedName("iabCategories") val iabCategories: List<Int>,
    @SerializedName("images") val images: Images,
    @SerializedName("countries") val countries: List<String>,
    @SerializedName("locale") val locale: String,
    @SerializedName("publishedAt") val publishedAt: Int,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("persons") val persons: List<Persons>,
    @SerializedName("topics") val topics: List<Topics>,
    @SerializedName("views") val views: Int,
    @SerializedName("isPreview") val isPreview: Boolean,
    @SerializedName("contentURL") val contentURL: String,
    @SerializedName("recommendationId") val recommendationId: String
)