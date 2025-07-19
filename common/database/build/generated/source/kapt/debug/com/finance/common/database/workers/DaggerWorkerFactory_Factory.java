package com.finance.common.database.workers;

import com.finance.common.database.repository.OfflineTransactionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DaggerWorkerFactory_Factory implements Factory<DaggerWorkerFactory> {
  private final Provider<OfflineTransactionRepository> offlineRepositoryProvider;

  public DaggerWorkerFactory_Factory(
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    this.offlineRepositoryProvider = offlineRepositoryProvider;
  }

  @Override
  public DaggerWorkerFactory get() {
    return newInstance(offlineRepositoryProvider.get());
  }

  public static DaggerWorkerFactory_Factory create(
      javax.inject.Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new DaggerWorkerFactory_Factory(Providers.asDaggerProvider(offlineRepositoryProvider));
  }

  public static DaggerWorkerFactory_Factory create(
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new DaggerWorkerFactory_Factory(offlineRepositoryProvider);
  }

  public static DaggerWorkerFactory newInstance(OfflineTransactionRepository offlineRepository) {
    return new DaggerWorkerFactory(offlineRepository);
  }
}
