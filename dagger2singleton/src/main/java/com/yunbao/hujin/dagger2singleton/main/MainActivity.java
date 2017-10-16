package com.yunbao.hujin.dagger2singleton.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.yunbao.hujin.dagger2singleton.DaggerApplication;
import com.yunbao.hujin.dagger2singleton.R;
import com.yunbao.hujin.dagger2singleton.http.taobao.model.TaobaoIPLocationInfo;
import com.yunbao.hujin.dagger2singleton.main.contract.MainContract;
import com.yunbao.hujin.dagger2singleton.main.module.MainModule;
import com.yunbao.hujin.dagger2singleton.main.presenter.MainPresenter;

import javax.inject.Inject;

/**
 * Main中主要处理（MVP）：
 * Step1 创建Activity的module
 * Step2 创建Activity的Conponent
 * Step3 改造AppComponent
 *      在AppComponent类中添加一行:MainComponent addSub(MainModule mainModule);
 *
 * Step4 MVP构建
 *      1、创建MainContract
 *      2、创建Presenter（注意@Inject）
 *      3、Activity（需要关注addSub方法、Inject方法）
 *
 */
public class MainActivity extends AppCompatActivity implements MainContract.View {

    private TextView city;
    private TextView cityCode;
    private TextView ip;
    private TextView isp;

    //注入presenter 对象
    @Inject
    MainPresenter mainPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActivityComponent();
        bindView();
        mainPresenter.main();
    }

    private void bindView() {
        city = (TextView) findViewById(R.id.city);
        cityCode = (TextView) findViewById(R.id.cityCode);
        ip = (TextView) findViewById(R.id.ip);
        isp = (TextView) findViewById(R.id.isp);
    }

    /**
     * 初始化属于自己Activity的Component对象
     * 本例将MainComponent添加成为AppComponent的子Component
     */
    private void setupActivityComponent() {
        DaggerApplication.get(this)
                .getAppComponent()
                //将AppComponent继承然后转换成MainComponent
                //MainModule的构造器中传递的是View接口的实例化对象
                .addSub(new MainModule(this))
                .inject(this);
    }




    /***********------MainContract.View-----*************/
    /**
     * MVP Presenter 中的回调
     * @param taobaoIPLocationInfo IP定位后的返回信息
     */
    @Override
    public void showLocationInfo(TaobaoIPLocationInfo taobaoIPLocationInfo) {
        if (taobaoIPLocationInfo.getData() == null) {
            return;
        }
        city.setText(String.format("定位城市：%s", taobaoIPLocationInfo.getData().getCity()));
        cityCode.setText(String.format("定位城市代码：%s", taobaoIPLocationInfo.getData().getCity_id()));
        ip.setText(String.format("地位地区IP：%s", taobaoIPLocationInfo.getData().getIp()));
        isp.setText(String.format("isp服务提供商：%s", taobaoIPLocationInfo.getData().getIsp()));
    }

    /**
     * MVP Presenter 中的回调
     */
    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Log.e("Tag-MainActivity:", message);
    }



}
