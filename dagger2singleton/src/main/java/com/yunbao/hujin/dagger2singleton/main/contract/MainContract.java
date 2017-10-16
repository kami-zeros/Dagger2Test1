package com.yunbao.hujin.dagger2singleton.main.contract;

import com.yunbao.hujin.dagger2singleton.http.taobao.model.TaobaoIPLocationInfo;

/**
 * Created by Administrator on 2017/10/16.
 */

public interface MainContract {

    interface View{
        void showLocationInfo(TaobaoIPLocationInfo taobaoIPLocationInfo);

        void showError(String message);
    }

    interface presenter{

    }
}
