package com.zmm.dagger2b.http;

import com.zmm.dagger2b.bean.BaseBean;
import com.zmm.dagger2b.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/31
 * Email:65489469@qq.com
 */
public interface ApiService {


    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("api/user/login.json")
    Observable<BaseBean<UserBean>> login(@Field("loginId") String phone, @Field("password") String password);
}
