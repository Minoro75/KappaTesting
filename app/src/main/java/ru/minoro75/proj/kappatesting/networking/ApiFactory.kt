package ru.minoro75.proj.kappatesting.networking

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.HTTP
import ru.minoro75.proj.kappatesting.data.NewsApi

object ApiFactory {
    var BASE_URL: String = "https://api.nytimes.com/"
    val getClient: NewsApi
        get() {

            val interceptor = HttpLoggingInterceptor()

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