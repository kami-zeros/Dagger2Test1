package com.yunbao.hujin.dagger2singleton.http.local.service;

import com.yunbao.hujin.dagger2singleton.http.local.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/10/16.
 */

public interface UserService {
    @GET("/users")
    Observable<Response<List<User>>> getUser();

    @GET("/users/{id}")
    Observable<Response<User>> getUserById(@Path("id") String id);

}
