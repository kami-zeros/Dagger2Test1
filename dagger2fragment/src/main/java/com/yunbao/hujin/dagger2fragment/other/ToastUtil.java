package com.yunbao.hujin.dagger2fragment.other;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/10/18.
 */

public class ToastUtil {

    private Context context;

    public ToastUtil(Context context) {
        this.context = context;
    }

    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
