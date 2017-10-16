package com.yunbao.hujin.dagger2fragment.app;

import android.content.Context;
import com.yunbao.hujin.dagger2fragment.other.ToastUtil;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideToastUtilFactory implements Factory<ToastUtil> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideToastUtilFactory(AppModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public ToastUtil get() {
    return Preconditions.checkNotNull(
        module.provideToastUtil(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ToastUtil> create(AppModule module, Provider<Context> contextProvider) {
    return new AppModule_ProvideToastUtilFactory(module, contextProvider);
  }
}
