package com.yunbao.hujin.dagger2singleton.http.taobao.service;

import com.yunbao.hujin.dagger2singleton.http.taobao.model.TaobaoIPLocationInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/10/16.
 */

public interface TaobaoIPLocationService {

    @GET("/service/getIpInfo2.php")
    Observable<TaobaoIPLocationInfo> getIPInfo(@Query("ip") String ip);
}
