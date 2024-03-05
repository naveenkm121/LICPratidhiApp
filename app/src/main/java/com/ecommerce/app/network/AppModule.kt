package com.ecommerce.app.network

import android.content.Context
import com.ecommerce.app.constants.Constants
import com.ecommerce.app.services.api.ProductService
import com.ecommerce.app.services.api.UserService
import com.ecommerce.app.utils.SaveSharedPreference
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


@Module
@InstallIn(SingletonComponent::class)
class
AppModule {

/*
    private val httpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    val authInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val token = SaveSharedPreference.getUserDetails(context = null)?.token
            val originalRequest: Request = chain.request()
            val requestBuilder: Request.Builder = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")

            val request: Request = requestBuilder.build()
            return chain.proceed(request)
        }
    }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }*/

/*
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
*/


/*
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideRetrofit(gson: Gson,okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()*/


    @Provides
    @Singleton
    @Named("ecommerceAuthOkHttpClient")
    fun provideEcommerceAuthOkHttpClient(@ApplicationContext appContext: Context): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .addInterceptor { chain: Interceptor.Chain ->
                val original: Request = chain.request()
                val token =SaveSharedPreference.getTokenValue(appContext)
                val requestBuilder: Request.Builder = original.newBuilder()
                    .header("Authorization", "Bearer $token")
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(@Named("ecommerceAuthOkHttpClient")ecommerceAuthOkHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(ecommerceAuthOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .client(unSafeOkHttpClient().build())
            .build()

    @Provides
    fun provideProductService(retrofit: Retrofit): ProductService =
        retrofit.create(ProductService::class.java)

    @Provides
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()




    fun unSafeOkHttpClient() :OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()
        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts:  Array<TrustManager> = arrayOf(object : X509TrustManager {
                override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?){}
                override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                override fun getAcceptedIssuers(): Array<X509Certificate>  = arrayOf()
            })

            // Install the all-trusting trust manager
            val  sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory
            if (trustAllCerts.isNotEmpty() &&  trustAllCerts.first() is X509TrustManager) {
                okHttpClient.sslSocketFactory(sslSocketFactory, trustAllCerts.first() as X509TrustManager)
                okHttpClient.hostnameVerifier { _, _ -> true } // change here
            }

            return okHttpClient
        } catch (e: Exception) {
            return okHttpClient
        }
    }

}