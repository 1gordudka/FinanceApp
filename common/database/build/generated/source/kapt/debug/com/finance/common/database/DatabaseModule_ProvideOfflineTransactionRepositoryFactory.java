package com.finance.common.database;

import android.content.Context;
import com.finance.common.database.dao.TransactionDao;
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
public final class DatabaseModule_ProvideOfflineTransactionRepositoryFactory implements Factory<OfflineTransactionRepository> {
  private final DatabaseModule module;

  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideOfflineTransactionRepositoryFactory(DatabaseModule module,
      Provider<TransactionDao> transactionDaoProvider, Provider<Context> contextProvider) {
    this.module = module;
    this.transactionDaoProvider = transactionDaoProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public OfflineTransactionRepository get() {
    return provideOfflineTransactionRepository(module, transactionDaoProvider.get(), contextProvider.get());
  }

  public static DatabaseModule_ProvideOfflineTransactionRepositoryFactory create(
      DatabaseModule module, javax.inject.Provider<TransactionDao> transactionDaoProvider,
      javax.inject.Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideOfflineTransactionRepositoryFactory(module, Providers.asDaggerProvider(transactionDaoProvider), Providers.asDaggerProvider(contextProvider));
  }

  public static DatabaseModule_ProvideOfflineTransactionRepositoryFactory create(
      DatabaseModule module, Provider<TransactionDao> transactionDaoProvider,
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideOfflineTransactionRepositoryFactory(module, transactionDaoProvider, contextProvider);
  }

  public static OfflineTransactionRepository provideOfflineTransactionRepository(
      DatabaseModule instance, TransactionDao transactionDao, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideOfflineTransactionRepository(transactionDao, context));
  }
}
