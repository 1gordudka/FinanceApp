package com.finance.common.database;

import android.content.Context;
import com.finance.common.database.repository.OfflineTransactionRepository;
import com.finance.common.database.sync.SyncStatusManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideSyncStatusManagerFactory implements Factory<SyncStatusManager> {
  private final DatabaseModule module;

  private final Provider<Context> contextProvider;

  private final Provider<OfflineTransactionRepository> offlineRepositoryProvider;

  public DatabaseModule_ProvideSyncStatusManagerFactory(DatabaseModule module,
      Provider<Context> contextProvider,
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.offlineRepositoryProvider = offlineRepositoryProvider;
  }

  @Override
  public SyncStatusManager get() {
    return provideSyncStatusManager(module, contextProvider.get(), offlineRepositoryProvider.get());
  }

  public static DatabaseModule_ProvideSyncStatusManagerFactory create(DatabaseModule module,
      javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new DatabaseModule_ProvideSyncStatusManagerFactory(module, Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(offlineRepositoryProvider));
  }

  public static DatabaseModule_ProvideSyncStatusManagerFactory create(DatabaseModule module,
      Provider<Context> contextProvider,
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new DatabaseModule_ProvideSyncStatusManagerFactory(module, contextProvider, offlineRepositoryProvider);
  }

  public static SyncStatusManager provideSyncStatusManager(DatabaseModule instance, Context context,
      OfflineTransactionRepository offlineRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideSyncStatusManager(context, offlineRepository));
  }
}
