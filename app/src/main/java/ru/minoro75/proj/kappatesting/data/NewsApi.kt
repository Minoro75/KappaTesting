package ru.minoro75.proj.kappatesting.data


import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NewsApi {
    @GET("svc/mostpopular/v2/emailed/7")
    fun getEmailedNews(): Response<NYTNewsResponse>

    companion object {
        var BASE_URL: String = "https://api.nytimes.com/"
        fun getApi(): NewsApi {
            var interceptor = HttpLoggingInterceptor()
            val okhttp = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    var request = chain.request()
                    val url = request.url().newBuilder()
                        .addQueryParameter("api-key", "xPLvtKSHvG0f5alLcYJ79NQfyA0alh5S")
                        .addPathSegment("json")
                        .build()
                    request = request.newBuilder().url(url).build()
                    chain.proceed(request)
                }
                .addInterceptor(interceptor)
                .build()

            val gsonBuilder = GsonBuilder()
            gsonBuilder.setLenient()
            val gsonFactory = GsonConverterFactory.create(gsonBuilder.create())

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okhttp)
                .addConverterFactory(gsonFactory)
                .build()
                .create(NewsApi::class.java)
        }
    }

    // @GET("shared/1/facebook")
    //fun getSharedNews():Deferred<Response<NewsResponse>>

    //@GET("viewed/1")
    //fun getViewedNews():Deferred<Response<NewsResponse>>
}