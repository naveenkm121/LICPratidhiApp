// Generated by Dagger (https://dagger.dev).
package com.licapps.bmmis.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata
@QualifierMetadata({
    "javax.inject.Named",
    "dagger.hilt.android.qualifiers.ApplicationContext"
})
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideAnandaOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<Context> appContextProvider;

  public AppModule_ProvideAnandaOkHttpClientFactory(Provider<Context> appContextProvider) {
    this.appContextProvider = appContextProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideAnandaOkHttpClient(appContextProvider.get());
  }

  public static AppModule_ProvideAnandaOkHttpClientFactory create(
      Provider<Context> appContextProvider) {
    return new AppModule_ProvideAnandaOkHttpClientFactory(appContextProvider);
  }

  public static OkHttpClient provideAnandaOkHttpClient(Context appContext) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAnandaOkHttpClient(appContext));
  }
}
