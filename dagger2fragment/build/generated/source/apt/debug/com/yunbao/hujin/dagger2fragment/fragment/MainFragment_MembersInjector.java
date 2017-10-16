package com.yunbao.hujin.dagger2fragment.fragment;

import com.yunbao.hujin.dagger2fragment.other.ToastUtil;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainFragment_MembersInjector implements MembersInjector<MainFragment> {
  private final Provider<MainFragmentContact.Presenter> mainPresenterProvider;

  private final Provider<ToastUtil> toastUtilProvider;

  public MainFragment_MembersInjector(
      Provider<MainFragmentContact.Presenter> mainPresenterProvider,
      Provider<ToastUtil> toastUtilProvider) {
    this.mainPresenterProvider = mainPresenterProvider;
    this.toastUtilProvider = toastUtilProvider;
  }

  public static MembersInjector<MainFragment> create(
      Provider<MainFragmentContact.Presenter> mainPresenterProvider,
      Provider<ToastUtil> toastUtilProvider) {
    return new MainFragment_MembersInjector(mainPresenterProvider, toastUtilProvider);
  }

  @Override
  public void injectMembers(MainFragment instance) {
    injectMainPresenter(instance, mainPresenterProvider.get());
    injectToastUtil(instance, toastUtilProvider.get());
  }

  public static void injectMainPresenter(
      MainFragment instance, MainFragmentContact.Presenter mainPresenter) {
    instance.mainPresenter = mainPresenter;
  }

  public static void injectToastUtil(MainFragment instance, ToastUtil toastUtil) {
    instance.toastUtil = toastUtil;
  }
}
