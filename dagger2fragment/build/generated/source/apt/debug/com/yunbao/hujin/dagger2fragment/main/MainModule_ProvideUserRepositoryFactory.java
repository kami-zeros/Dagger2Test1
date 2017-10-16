package com.yunbao.hujin.dagger2fragment.main;

import com.yunbao.hujin.dagger2fragment.other.UserRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
  private final MainModule module;

  public MainModule_ProvideUserRepositoryFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public UserRepository get() {
    return Preconditions.checkNotNull(
        module.provideUserRepository(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserRepository> create(MainModule module) {
    return new MainModule_ProvideUserRepositoryFactory(module);
  }
}
