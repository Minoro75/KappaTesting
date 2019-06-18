package ru.minoro75.proj.kappatesting.data

import com.google.gson.annotations.SerializedName

/*pojo class with news in gson format */
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

