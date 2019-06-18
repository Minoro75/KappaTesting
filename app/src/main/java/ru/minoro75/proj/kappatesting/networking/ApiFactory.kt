package ru.minoro75.proj.kappatesting.networking

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HTTP
import ru.minoro75.proj.kappatesting.BuildConfig
import ru.minoro75.proj.kappatesting.data.NewsApi

object ApiFactory {

    var BASE_URL: String = "https://api.nytimes.com/"
    fun get(): NewsApi {

        val loggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttp = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    var request = chain.request()
                    val url = request.url().newBuilder()
                        .addQueryParameter("api-key", "4BiMeVwjIKSXhgMxjTV0vgnyLXWIVmtZ")
//                            .addPathSegment("json")
                        .build()

                    request = request.newBuilder().url(url).build()
                    chain.proceed(request)
                }
            .addInterceptor(loggingInterceptor)
                .build()

            val gsonBuilder = GsonBuilder()
            gsonBuilder.setLenient()
            val gsonFactory = GsonConverterFactory.create(gsonBuilder.create())

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttp)
                .addConverterFactory(gsonFactory)
                .build()
                .create(NewsApi::class.java)
        }
}