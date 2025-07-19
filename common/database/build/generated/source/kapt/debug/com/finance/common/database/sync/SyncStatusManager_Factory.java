package com.finance.common.database.sync;

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
public final class SyncStatusManager_Factory implements Factory<SyncStatusManager> {
  private final Provider<Context> contextProvider;

  private final Provider<OfflineTransactionRepository> offlineRepositoryProvider;

  public SyncStatusManager_Factory(Provider<Context> contextProvider,
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.offlineRepositoryProvider = offlineRepositoryProvider;
  }

  @Override
  public SyncStatusManager get() {
    return newInstance(contextProvider.get(), offlineRepositoryProvider.get());
  }

  public static SyncStatusManager_Factory create(javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new SyncStatusManager_Factory(Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(offlineRepositoryProvider));
  }

  public static SyncStatusManager_Factory create(Provider<Context> contextProvider,
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new SyncStatusManager_Factory(contextProvider, offlineRepositoryProvider);
  }

  public static SyncStatusManager newInstance(Context context,
      OfflineTransactionRepository offlineRepository) {
    return new SyncStatusManager(context, offlineRepository);
  }
}
