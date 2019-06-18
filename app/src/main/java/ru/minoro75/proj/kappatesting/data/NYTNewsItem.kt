package ru.minoro75.proj.kappatesting.data

import com.google.gson.annotations.SerializedName

/*pojo class with gson serialized input*/
data class NYTNewsItem(
    @SerializedName("title")
    var title: String = "",
    @SerializedName("published_date")
    var published_date: String = ""
)