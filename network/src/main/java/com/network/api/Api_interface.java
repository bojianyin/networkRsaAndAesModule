package com.network.api;

import com.network.bean.BaseBean;
import com.network.bean.LoginBean;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface Api_interface {

    @POST("/api/login/testLogin2")
    Observable<BaseBean<LoginBean>> dologin(@Body RequestBody params);

}
