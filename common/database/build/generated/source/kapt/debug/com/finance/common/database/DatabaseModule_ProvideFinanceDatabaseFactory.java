package com.finance.common.database;

import android.content.Context;
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
public final class DatabaseModule_ProvideFinanceDatabaseFactory implements Factory<FinanceDatabase> {
  private final DatabaseModule module;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideFinanceDatabaseFactory(DatabaseModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public FinanceDatabase get() {
    return provideFinanceDatabase(module, contextProvider.get());
  }

  public static DatabaseModule_ProvideFinanceDatabaseFactory create(DatabaseModule module,
      javax.inject.Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideFinanceDatabaseFactory(module, Providers.asDaggerProvider(contextProvider));
  }

  public static DatabaseModule_ProvideFinanceDatabaseFactory create(DatabaseModule module,
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideFinanceDatabaseFactory(module, contextProvider);
  }

  public static FinanceDatabase provideFinanceDatabase(DatabaseModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideFinanceDatabase(context));
  }
}
