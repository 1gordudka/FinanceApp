package com.finance.common.database;

import com.finance.common.database.dao.TransactionDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class DatabaseModule_ProvideTransactionDaoFactory implements Factory<TransactionDao> {
  private final DatabaseModule module;

  private final Provider<FinanceDatabase> databaseProvider;

  public DatabaseModule_ProvideTransactionDaoFactory(DatabaseModule module,
      Provider<FinanceDatabase> databaseProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TransactionDao get() {
    return provideTransactionDao(module, databaseProvider.get());
  }

  public static DatabaseModule_ProvideTransactionDaoFactory create(DatabaseModule module,
      javax.inject.Provider<FinanceDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTransactionDaoFactory(module, Providers.asDaggerProvider(databaseProvider));
  }

  public static DatabaseModule_ProvideTransactionDaoFactory create(DatabaseModule module,
      Provider<FinanceDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTransactionDaoFactory(module, databaseProvider);
  }

  public static TransactionDao provideTransactionDao(DatabaseModule instance,
      FinanceDatabase database) {
    return Preconditions.checkNotNullFromProvides(instance.provideTransactionDao(database));
  }
}
