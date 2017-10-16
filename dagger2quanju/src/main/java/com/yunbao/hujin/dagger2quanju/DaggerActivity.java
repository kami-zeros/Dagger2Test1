package com.yunbao.hujin.dagger2quanju;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.yunbao.hujin.dagger2quanju.component.AppComponent;
import com.yunbao.hujin.dagger2quanju.component.DaggerActivityComponent;
import com.yunbao.hujin.dagger2quanju.model.User;
import com.yunbao.hujin.dagger2quanju.model.YbApp;
import com.yunbao.hujin.dagger2quanju.module.ActivityModule;
import com.yunbao.hujin.dagger2quanju.presenter.DaggerPresenter;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 此包：介绍 全局注解 的 使用
 * （其实是在Application里进行实现-构建-并返回实例-进行注解）
 */
public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";
    TextView text;

    //持有一个DaggerPresenter的成员
    @Inject
    DaggerPresenter presenter;


    //全局
    @Inject
    OkHttpClient client;
    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        text = (TextView) findViewById(R.id.text);

        inject();

        presenter.showUserName();

        Log.e("Tag-" + TAG, "client = " + (client == null ? "null" : client));
        Log.e("Tag-" + TAG, "retrofit = " + (retrofit == null ? "null" : retrofit));
    }

    private void inject() {
        AppComponent appComponent = ((MyApplication) getApplication()).getAppComponent();
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    /*
     * ActivityModule 里的provideUser方法已经去掉了，那么根据我前面说的话，
     * 那我们需要从哪里获取这个User对象呢。
     * 可以看到这个ActivityComponent是依赖AppComponent的，AppComponent中定义了3个方法：
     *      OkHttpClient getClient();
     *      Retrofit getRetrofit();
     *      User getUser();
     * 值得注意的是这三个方法也是根据返回值类型来识别的，
     * 他们会分别找到AppComponent中的module(ApiModule)中的provide方法来获取对象。
     */


    public void showUserName(String name) {
        text.setText(name);
        Log.e("Tag-", user.name);
//        ybApp.saveToken("myTRest-" + user.name);
    }

//    @Inject
//    YbApp ybApp;
@Inject
User user;

}
