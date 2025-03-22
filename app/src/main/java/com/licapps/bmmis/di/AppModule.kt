package com.licapps.bmmis.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.licapps.bmmis.data.api.PlanRemoteDataSource
import com.licapps.bmmis.data.api.PlanServices
import com.licapps.bmmis.data.localdb.AppDatabase
import com.licapps.bmmis.data.localdb.PlanDao
import com.licapps.bmmis.data.repository.PlansRepository
import com.licapps.bmmis.constants.Constants
import com.licapps.bmmis.data.api.BMMisRemoteDataSource
import com.licapps.bmmis.data.api.AnandaServices
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.SaveSharedPreference
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
import java.util.concurrent.TimeUnit
import java.util.prefs.Preferences
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Used for consuming PremiumCalculator App backend services
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

    //Used for consuming ananda backend services
    @Provides
    @Named("anandaOkHttpClient")
    fun provideAnandaOkHttpClient(@ApplicationContext appContext: Context): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .addInterceptor { chain: Interceptor.Chain ->
                val original: Request = chain.request()
                val token =SaveSharedPreference.getUserDetails(appContext)?.token
                val requestBuilder: Request.Builder = original.newBuilder()
                    .header("Authorization", "Bearer $token")
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
            .addInterceptor(interceptor)
            .build()
    }


    @Provides
    fun provideRetrofit(gson: Gson,okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL_PROD)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()


    @Provides
    @Named("anandaRetrofit")
    fun provideAnandaRetrofit(gson: Gson, @Named("anandaOkHttpClient")anandaOkHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL_PROD)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(anandaOkHttpClient)
        .build()
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun providePlanServices(retrofit: Retrofit): PlanServices = retrofit.create(PlanServices::class.java)

    @Provides
    fun provideAnandaServices( @Named("anandaRetrofit") retrofit: Retrofit): AnandaServices = retrofit.create(AnandaServices::class.java)

    @Singleton
    @Provides
    fun providePlanRemoteDataSource(planServices: PlanServices) = PlanRemoteDataSource(planServices)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun providePlanDao(db: AppDatabase) = db.planDao()


    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: PlanRemoteDataSource,
                          localDataSource: PlanDao
    ) =
        PlansRepository(remoteDataSource, localDataSource)

    @Singleton
    @Provides
    fun provideAnandaRepository(remoteDataSource: BMMisRemoteDataSource,
                                localDataSource: PlanDao
    ) =
        AnandaRepository(remoteDataSource, localDataSource)

}