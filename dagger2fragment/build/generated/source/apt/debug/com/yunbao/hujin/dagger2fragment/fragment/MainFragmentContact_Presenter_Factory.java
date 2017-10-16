package com.yunbao.hujin.dagger2fragment.fragment;

import com.yunbao.hujin.dagger2fragment.other.UserRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainFragmentContact_Presenter_Factory
    implements Factory<MainFragmentContact.Presenter> {
  private final Provider<UserRepository> userRepositoryProvider;

  public MainFragmentContact_Presenter_Factory(Provider<UserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public MainFragmentContact.Presenter get() {
    return new MainFragmentContact.Presenter(userRepositoryProvider.get());
  }

  public static Factory<MainFragmentContact.Presenter> create(
      Provider<UserRepository> userRepositoryProvider) {
    return new MainFragmentContact_Presenter_Factory(userRepositoryProvider);
  }
}
