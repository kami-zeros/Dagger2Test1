package com.yunbao.hujin.dagger2fragment.main;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yunbao.hujin.dagger2fragment.R;
import com.yunbao.hujin.dagger2fragment.base.ActivityModule;
import com.yunbao.hujin.dagger2fragment.base.BaseActivity;
import com.yunbao.hujin.dagger2fragment.fragment.MainFragment;
import com.yunbao.hujin.dagger2fragment.main.DaggerMainComponent;
import com.yunbao.hujin.dagger2fragment.main.MainComponent;
import com.yunbao.hujin.dagger2fragment.main.MainModule;

public class MainActivity extends BaseActivity {

    private MainComponent mainComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainComponent = DaggerMainComponent.builder()
                .activityComponent(getActivityComponent())
                .mainModule(new MainModule())
                .build();
        mainComponent.inject(this);

        initFragment();
    }



    public MainComponent getMainComponent() {
        return mainComponent;
    }



    MainFragment mainFragment;
    private void initFragment() {
        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, mainFragment)
                .show(mainFragment)
                .commit();
    }





    /**
     * 另一种写法
     */
//    private MainComponent mainComponent;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mainComponent = DaggerMainComponent.builder()
//                .appComponent(getAppComponent())
//                .activityModule(new ActivityModule(this))
//                .mainModule(new MainModule())
//                .build();
//        mainComponent.inject(this);
//
//        initFragment();
//
//    }
//    MainFragment mainFragment;
//    private void initFragment() {
//        mainFragment = new MainFragment();
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.content, mainFragment)
//                .show(mainFragment)
//                .commit();
//    }
//    public MainComponent getMainComponent() {
//        return this.mainComponent;
//    }


}
