package ml.mylittlebackend.jji6wk.data.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    companion object {
        const val BASE_URL = "http://192.168.0.218:3000/"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(interceptor)
            .addInterceptor(ReceivedCookiesInterceptor())
            .addInterceptor(AddCookiesInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .build()
                )
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthAPI = retrofit.create(AuthAPI::class.java)

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserAPI = retrofit.create(UserAPI::class.java)

    @Provides
    @Singleton
    fun provideAlbumApi(retrofit: Retrofit): AlbumAPI = retrofit.create(AlbumAPI::class.java)

}

class CookieManager {
    companion object {
        var savedCookies: HashSet<String> = hashSetOf()
    }
}

class ReceivedCookiesInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse: Response = chain.proceed(chain.request())
        if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
            val cookies = CookieManager.savedCookies
            for (header in originalResponse.headers("Set-Cookie")) {
                if (header.contains("authenticatedUser")) {
                    cookies.clear()
                    cookies.add(header)
                }
            }
        }
        return originalResponse
    }
}

class AddCookiesInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val cookies = CookieManager.savedCookies
        for (cookie in cookies) {
            builder.addHeader("Cookie", cookie)
        }
        return chain.proceed(builder.build())
    }

    companion object {
        const val PREF_COOKIES = "PREF_COOKIES"
    }

}