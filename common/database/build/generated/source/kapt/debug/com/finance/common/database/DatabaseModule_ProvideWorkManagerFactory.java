package com.finance.common.database;

import android.content.Context;
import androidx.work.WorkManager;
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
public final class DatabaseModule_ProvideWorkManagerFactory implements Factory<WorkManager> {
  private final DatabaseModule module;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideWorkManagerFactory(DatabaseModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public WorkManager get() {
    return provideWorkManager(module, contextProvider.get());
  }

  public static DatabaseModule_ProvideWorkManagerFactory create(DatabaseModule module,
      javax.inject.Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideWorkManagerFactory(module, Providers.asDaggerProvider(contextProvider));
  }

  public static DatabaseModule_ProvideWorkManagerFactory create(DatabaseModule module,
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideWorkManagerFactory(module, contextProvider);
  }

  public static WorkManager provideWorkManager(DatabaseModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideWorkManager(context));
  }
}
