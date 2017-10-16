package com.yunbao.hujin.dagger2fragment.app;

import android.content.Context;
import com.yunbao.hujin.dagger2fragment.other.ToastUtil;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<Context> provideContextProvider;

  private Provider<ToastUtil> provideToastUtilProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideContextProvider =
        DoubleCheck.provider(AppModule_ProvideContextFactory.create(builder.appModule));
    this.provideToastUtilProvider =
        DoubleCheck.provider(
            AppModule_ProvideToastUtilFactory.create(builder.appModule, provideContextProvider));
  }

  @Override
  public Context getContext() {
    return provideContextProvider.get();
  }

  @Override
  public ToastUtil getToastUtil() {
    return provideToastUtilProvider.get();
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }
}
