package com.finance.common.database;

import android.content.Context;
import com.finance.common.database.demo.DemoDataManager;
import com.finance.common.database.repository.OfflineTransactionRepository;
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
public final class DatabaseModule_ProvideDemoDataManagerFactory implements Factory<DemoDataManager> {
  private final DatabaseModule module;

  private final Provider<Context> contextProvider;

  private final Provider<OfflineTransactionRepository> offlineRepositoryProvider;

  public DatabaseModule_ProvideDemoDataManagerFactory(DatabaseModule module,
      Provider<Context> contextProvider,
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.offlineRepositoryProvider = offlineRepositoryProvider;
  }

  @Override
  public DemoDataManager get() {
    return provideDemoDataManager(module, contextProvider.get(), offlineRepositoryProvider.get());
  }

  public static DatabaseModule_ProvideDemoDataManagerFactory create(DatabaseModule module,
      javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new DatabaseModule_ProvideDemoDataManagerFactory(module, Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(offlineRepositoryProvider));
  }

  public static DatabaseModule_ProvideDemoDataManagerFactory create(DatabaseModule module,
      Provider<Context> contextProvider,
      Provider<OfflineTransactionRepository> offlineRepositoryProvider) {
    return new DatabaseModule_ProvideDemoDataManagerFactory(module, contextProvider, offlineRepositoryProvider);
  }

  public static DemoDataManager provideDemoDataManager(DatabaseModule instance, Context context,
      OfflineTransactionRepository offlineRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideDemoDataManager(context, offlineRepository));
  }
}
