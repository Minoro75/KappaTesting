package ru.minoro75.proj.kappatesting.networking

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.minoro75.proj.kappatesting.data.NewsApi

class ApiModule {
    private var BASE_URL: String = "https://api.nytimes.com/"
    fun getApi(): NewsApi {
        var interceptor = HttpLoggingInterceptor()
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
            .addInterceptor(interceptor)
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