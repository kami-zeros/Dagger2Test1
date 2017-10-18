package com.yunbao.hujin.dagger2fragment.fragment;

import com.yunbao.hujin.dagger2fragment.other.User;
import com.yunbao.hujin.dagger2fragment.other.UserRepository;

import javax.inject.Inject;

/**
 * MVP模式： on 2017/10/18.
 */

public class MainFragmentContact {

    public interface View{
        void setUserName(String name);

        void showToast(String msg);
    }


    /**
     * 内部类注入时，必须使用 static 的，
     */
    public static class Presenter{
        public UserRepository userRepository;
        private View view;

        @Inject
        public Presenter(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public void setView(View view) {
            this.view = view;
        }
        public void toastButtonClick() {
            String msg = "hello world";
            view.showToast(msg);
        }
        public void userInfoButtonClick() {
            User userData = this.userRepository.getUser();
            this.view.setUserName((userData.name));
        }

    }


}
