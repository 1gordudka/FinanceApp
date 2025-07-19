package com.finance.common.database.demo;

import android.content.Context;
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
public final class DemoDataManager_Factory implements Factory<DemoDataManager> {
  private final Provider<Context> contextProvider;

  private final Provider<OfflineTransactionRepository> offlineRepositoryProvider;

  public DemoDataManager_Factory(Provider<Context> contextProvider,
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.offlineRepositoryProvider = offlineRepositoryProvider;
  }

  @Override
  public DemoDataManager get() {
    return newInstance(contextProvider.get(), offlineRepositoryProvider.get());
  }

  public static DemoDataManager_Factory create(javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new DemoDataManager_Factory(Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(offlineRepositoryProvider));
  }

  public static DemoDataManager_Factory create(Provider<Context> contextProvider,
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new DemoDataManager_Factory(contextProvider, offlineRepositoryProvider);
  }

  public static DemoDataManager newInstance(Context context,
      OfflineTransactionRepository offlineRepository) {
    return new DemoDataManager(context, offlineRepository);
  }
}
