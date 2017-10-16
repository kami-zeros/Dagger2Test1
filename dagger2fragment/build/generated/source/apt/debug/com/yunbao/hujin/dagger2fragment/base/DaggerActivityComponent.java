package com.yunbao.hujin.dagger2fragment.base;

import android.app.Activity;
import com.yunbao.hujin.dagger2fragment.app.AppComponent;
import com.yunbao.hujin.dagger2fragment.other.ToastUtil;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<Activity> provideActivityProvider;

  private AppComponent appComponent;

  private DaggerActivityComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideActivityProvider =
        DoubleCheck.provider(ActivityModule_ProvideActivityFactory.create(builder.activityModule));
    this.appComponent = builder.appComponent;
  }

  @Override
  public Activity getActivity() {
    return provideActivityProvider.get();
  }

  @Override
  public ToastUtil getToastUtil() {
    return Preconditions.checkNotNull(
        appComponent.getToastUtil(), "Cannot return null from a non-@Nullable component method");
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private AppComponent appComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }
  }
}
