package com.licapps.bmmis.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0004H\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u000eH\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0017\u001a\u00020\u0010H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0016H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0004H\u0007\u00a8\u0006$"}, d2 = {"Lcom/licapps/bmmis/di/AppModule;", "", "()V", "provideAnandaOkHttpClient", "Lokhttp3/OkHttpClient;", "appContext", "Landroid/content/Context;", "provideAnandaRepository", "Lcom/licapps/bmmis/data/repository/AnandaRepository;", "remoteDataSource", "Lcom/licapps/bmmis/data/api/BMMisRemoteDataSource;", "localDataSource", "Lcom/licapps/bmmis/data/localdb/PlanDao;", "provideAnandaRetrofit", "Lretrofit2/Retrofit;", "gson", "Lcom/google/gson/Gson;", "anandaOkHttpClient", "provideAnandaServices", "Lcom/licapps/bmmis/data/api/AnandaServices;", "retrofit", "provideDatabase", "Lcom/licapps/bmmis/data/localdb/AppDatabase;", "provideGson", "provideOkHttpClient", "providePlanDao", "db", "providePlanRemoteDataSource", "Lcom/licapps/bmmis/data/api/PlanRemoteDataSource;", "planServices", "Lcom/licapps/bmmis/data/api/PlanServices;", "providePlanServices", "provideRepository", "Lcom/licapps/bmmis/data/repository/PlansRepository;", "provideRetrofit", "okHttpClient", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.licapps.bmmis.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Named(value = "anandaOkHttpClient")
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideAnandaOkHttpClient(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Named(value = "anandaRetrofit")
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideAnandaRetrofit(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @javax.inject.Named(value = "anandaOkHttpClient")
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient anandaOkHttpClient) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.api.PlanServices providePlanServices(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.api.AnandaServices provideAnandaServices(@javax.inject.Named(value = "anandaRetrofit")
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.api.PlanRemoteDataSource providePlanRemoteDataSource(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.api.PlanServices planServices) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.localdb.AppDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.localdb.PlanDao providePlanDao(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.localdb.AppDatabase db) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.repository.PlansRepository provideRepository(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.api.PlanRemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.localdb.PlanDao localDataSource) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.repository.AnandaRepository provideAnandaRepository(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.api.BMMisRemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.localdb.PlanDao localDataSource) {
        return null;
    }
}