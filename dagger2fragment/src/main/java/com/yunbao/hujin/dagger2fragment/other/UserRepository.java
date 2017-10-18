package com.yunbao.hujin.dagger2fragment.other;

/**
 * Created by Administrator on 2017/10/18.
 */

public class UserRepository {

    public UserRepository() {
    }

    public User getUser() {
        User user = new User();
        user.name = "我在这里";
        return user;
    }

}
