// Generated by Dagger (https://dagger.dev).
package com.licapps.bmmis.di;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideAnandaRetrofitFactory implements Factory<Retrofit> {
  private final Provider<Gson> gsonProvider;

  private final Provider<OkHttpClient> anandaOkHttpClientProvider;

  public AppModule_ProvideAnandaRetrofitFactory(Provider<Gson> gsonProvider,
      Provider<OkHttpClient> anandaOkHttpClientProvider) {
    this.gsonProvider = gsonProvider;
    this.anandaOkHttpClientProvider = anandaOkHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return provideAnandaRetrofit(gsonProvider.get(), anandaOkHttpClientProvider.get());
  }

  public static AppModule_ProvideAnandaRetrofitFactory create(Provider<Gson> gsonProvider,
      Provider<OkHttpClient> anandaOkHttpClientProvider) {
    return new AppModule_ProvideAnandaRetrofitFactory(gsonProvider, anandaOkHttpClientProvider);
  }

  public static Retrofit provideAnandaRetrofit(Gson gson, OkHttpClient anandaOkHttpClient) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAnandaRetrofit(gson, anandaOkHttpClient));
  }
}
