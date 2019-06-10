package ru.minoro75.proj.kappatesting.data


import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("svc/mostpopular/v2/emailed/7")
    fun getEmailedNews(): Call<NYTNewsResponse>

    // @GET("shared/1/facebook")
    //fun getSharedNews():Deferred<Response<NewsResponse>>

    //@GET("viewed/1")
    //fun getViewedNews():Deferred<Response<NewsResponse>>
}