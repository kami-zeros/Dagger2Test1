package com.yunbao.hujin.dagger2extends.module;

import com.yunbao.hujin.dagger2extends.model.YbApp;
import com.yunbao.hujin.dagger2extends.qualifies.UserScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/10/14.
 */
@Module
public class UserHttpModule {

    public static final String END_POINT = "http://www.baidu.com";
    @UserScope
    @Provides
    public Retrofit providerUserRetrofit( OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

//    @Provides
//    YbApp provideYbApp() {
//        return new YbApp();
//    }
}
