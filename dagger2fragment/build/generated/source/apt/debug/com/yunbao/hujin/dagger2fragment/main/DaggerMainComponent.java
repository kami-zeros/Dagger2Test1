package com.yunbao.hujin.dagger2fragment.main;

import com.yunbao.hujin.dagger2fragment.base.ActivityComponent;
import com.yunbao.hujin.dagger2fragment.fragment.MainFragment;
import com.yunbao.hujin.dagger2fragment.fragment.MainFragmentComponent;
import com.yunbao.hujin.dagger2fragment.fragment.MainFragmentContact;
import com.yunbao.hujin.dagger2fragment.fragment.MainFragment_MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMainComponent implements MainComponent {
  private MainModule mainModule;

  private ActivityComponent activityComponent;

  private DaggerMainComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.mainModule = builder.mainModule;
    this.activityComponent = builder.activityComponent;
  }

  @Override
  public void inject(MainActivity mainActivity) {}

  @Override
  public MainFragmentComponent mainFragmentComponent() {
    return new MainFragmentComponentImpl();
  }

  public static final class Builder {
    private MainModule mainModule;

    private ActivityComponent activityComponent;

    private Builder() {}

    public MainComponent build() {
      if (mainModule == null) {
        this.mainModule = new MainModule();
      }
      if (activityComponent == null) {
        throw new IllegalStateException(
            ActivityComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerMainComponent(this);
    }

    public Builder mainModule(MainModule mainModule) {
      this.mainModule = Preconditions.checkNotNull(mainModule);
      return this;
    }

    public Builder activityComponent(ActivityComponent activityComponent) {
      this.activityComponent = Preconditions.checkNotNull(activityComponent);
      return this;
    }
  }

  private final class MainFragmentComponentImpl implements MainFragmentComponent {
    private MainFragmentComponentImpl() {}

    @Override
    public void inject(MainFragment mainFragment) {
      injectMainFragment(mainFragment);
    }

    private MainFragment injectMainFragment(MainFragment instance) {
      MainFragment_MembersInjector.injectMainPresenter(
          instance,
          new MainFragmentContact.Presenter(
              Preconditions.checkNotNull(
                  DaggerMainComponent.this.mainModule.provideUserRepository(),
                  "Cannot return null from a non-@Nullable @Provides method")));
      MainFragment_MembersInjector.injectToastUtil(
          instance,
          Preconditions.checkNotNull(
              DaggerMainComponent.this.activityComponent.getToastUtil(),
              "Cannot return null from a non-@Nullable component method"));
      return instance;
    }
  }
}
