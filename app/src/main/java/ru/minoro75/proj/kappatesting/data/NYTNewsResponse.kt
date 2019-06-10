package ru.minoro75.proj.kappatesting.data

import com.google.gson.annotations.SerializedName

data class NYTNewsResponse(
    @SerializedName("copyright")
    var copyright: String = "",

    @SerializedName("num_results")
    var numResults: Long = 0,

    @SerializedName("results")
    var results: List<NYTNewsItem> = ArrayList(),

    @SerializedName("status")
    var status: String = ""
)

