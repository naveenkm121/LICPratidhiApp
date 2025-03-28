// Generated by Dagger (https://dagger.dev).
package com.licapps.bmmis.data.repository;

import com.licapps.bmmis.data.api.PlanRemoteDataSource;
import com.licapps.bmmis.data.localdb.PlanDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class PlansRepository_Factory implements Factory<PlansRepository> {
  private final Provider<PlanRemoteDataSource> remoteDataSourceProvider;

  private final Provider<PlanDao> localDataSourceProvider;

  public PlansRepository_Factory(Provider<PlanRemoteDataSource> remoteDataSourceProvider,
      Provider<PlanDao> localDataSourceProvider) {
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.localDataSourceProvider = localDataSourceProvider;
  }

  @Override
  public PlansRepository get() {
    return newInstance(remoteDataSourceProvider.get(), localDataSourceProvider.get());
  }

  public static PlansRepository_Factory create(
      Provider<PlanRemoteDataSource> remoteDataSourceProvider,
      Provider<PlanDao> localDataSourceProvider) {
    return new PlansRepository_Factory(remoteDataSourceProvider, localDataSourceProvider);
  }

  public static PlansRepository newInstance(PlanRemoteDataSource remoteDataSource,
      PlanDao localDataSource) {
    return new PlansRepository(remoteDataSource, localDataSource);
  }
}
