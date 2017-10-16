package com.yunbao.hujin.dagger2singleton.main.presenter;

import android.content.SharedPreferences;

import com.yunbao.hujin.dagger2singleton.http.local.service.UserService;
import com.yunbao.hujin.dagger2singleton.http.taobao.model.TaobaoIPLocationInfo;
import com.yunbao.hujin.dagger2singleton.http.taobao.service.TaobaoIPLocationService;
import com.yunbao.hujin.dagger2singleton.main.contract.MainContract;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/16.
 */

public class MainPresenter implements MainContract.presenter{

    private final MainContract.View view;
    private final SharedPreferences sharedPreferences;
    private final TaobaoIPLocationService locationService;
    private final UserService userService;

    //此处关键，用来提供 Presenter 的实例化对象
    @Inject
    public MainPresenter(MainContract.View view,
                         @Named("default") SharedPreferences sharedPreferences,
                         TaobaoIPLocationService locationService,
                         UserService userService) {
        this.view = view;
        this.sharedPreferences = sharedPreferences;
        this.locationService = locationService;
        this.userService = userService;
    }

    //IP定位测试
    public void main() {
        locationService.getIPInfo("myip")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TaobaoIPLocationInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TaobaoIPLocationInfo taobaoIPLocationInfo) {
                        view.showLocationInfo(taobaoIPLocationInfo);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
