package com.yunbao.hujin.dagger2extends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yunbao.hujin.dagger2extends.component.DaggerUserHttpComponent;
import com.yunbao.hujin.dagger2extends.component.YbBasicComponent;
import com.yunbao.hujin.dagger2extends.component.YbNetworkComponent;
import com.yunbao.hujin.dagger2extends.model.YbApp;
import com.yunbao.hujin.dagger2extends.module.UserHttpModule;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 【注意】：发现有两层继承关系就 无法 注入成功
 *
 * 此包：介绍 【注解的继承关系】 发现以上关系---
 * （其实是在Application里进行实现-构建-并返回实例-进行注解）
 */
public class Dagger2Activity extends AppCompatActivity {
    private static final String TAG = "Dagger22Activity";

//    @Inject
    YbApp ybApp;


    @Inject
    OkHttpClient client;
    @Inject
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_two);

        ybApp = new YbApp();
        inject();
        Log.e("Tag-" + TAG, "client = " + (client == null ? "null" : client));
        Log.e("Tag-" + TAG, "retrofit = " + (retrofit == null ? "null" : retrofit));
        ybApp.saveToken("this is my test");
    }

    private void inject() {
        YbBasicComponent ybBasicComponent = YbEstopCore.getBasicComponent();
        YbNetworkComponent ybNetworkComponent = YbEstopCore.getNetworkComponent();

        DaggerUserHttpComponent.builder()
                .ybNetworkComponent(ybNetworkComponent)
//                .ybBasicComponent(ybBasicComponent)
                .userHttpModule(new UserHttpModule())
                .build()
                .inject(this);
    }
}
