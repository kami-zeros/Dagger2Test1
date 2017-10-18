package com.yunbao.hujin.dagger2fragment.main;

import com.yunbao.hujin.dagger2fragment.other.UserRepository;

import dagger.Module;
import dagger.Provides;

/**
 * MainModule中提供了 UserRepository，表示要给数据仓库，这里只是模拟数据。 on 2017/10/18.
 */
@Module
public class MainModule {

    @Provides
    public UserRepository provideUserRepository() {
        return new UserRepository();
    }

}
