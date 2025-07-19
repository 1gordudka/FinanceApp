package com.finance.common.database.repository;

import android.content.Context;
import com.finance.common.database.dao.TransactionDao;
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
public final class OfflineTransactionRepositoryImpl_Factory implements Factory<OfflineTransactionRepositoryImpl> {
  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<Context> contextProvider;

  public OfflineTransactionRepositoryImpl_Factory(Provider<TransactionDao> transactionDaoProvider,
      Provider<Context> contextProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public OfflineTransactionRepositoryImpl get() {
    return newInstance(transactionDaoProvider.get(), contextProvider.get());
  }

  public static OfflineTransactionRepositoryImpl_Factory create(
      javax.inject.Provider<TransactionDao> transactionDaoProvider,
      javax.inject.Provider<Context> contextProvider) {
    return new OfflineTransactionRepositoryImpl_Factory(Providers.asDaggerProvider(transactionDaoProvider), Providers.asDaggerProvider(contextProvider));
  }

  public static OfflineTransactionRepositoryImpl_Factory create(
      Provider<TransactionDao> transactionDaoProvider, Provider<Context> contextProvider) {
    return new OfflineTransactionRepositoryImpl_Factory(transactionDaoProvider, contextProvider);
  }

  public static OfflineTransactionRepositoryImpl newInstance(TransactionDao transactionDao,
      Context context) {
    return new OfflineTransactionRepositoryImpl(transactionDao, context);
  }
}
