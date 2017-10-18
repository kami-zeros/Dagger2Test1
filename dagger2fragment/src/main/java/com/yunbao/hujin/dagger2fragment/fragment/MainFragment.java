package com.yunbao.hujin.dagger2fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yunbao.hujin.dagger2fragment.R;
import com.yunbao.hujin.dagger2fragment.main.MainActivity;
import com.yunbao.hujin.dagger2fragment.other.ToastUtil;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/10/18.
 */

public class MainFragment extends Fragment implements MainFragmentContact.View {

    @Inject
    MainFragmentContact.Presenter mainPresenter;
    @Inject
    ToastUtil toastUtil;

    private MainFragmentComponent mainFragmentComponent;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof MainActivity) {
            mainFragmentComponent = ((MainActivity) getActivity())
                    .getMainComponent()
                    .mainFragmentComponent();
            mainFragmentComponent.inject(this);
        }
        mainPresenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnToast = (Button) view.findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.toastButtonClick();
            }
        });

        Button btnUserData = (Button) view.findViewById(R.id.btn_user_info);
        btnUserData.setOnClickListener(v-> {
                mainPresenter.userInfoButtonClick();
        });

    }

    /************--------MainFragmentContact.View接口--------***********/
    @Override
    public void setUserName(String name) {
        ((TextView) getView().findViewById(R.id.et_user)).setText(name);
    }

    @Override
    public void showToast(String msg) {
        toastUtil.showToast(msg);
    }
}
