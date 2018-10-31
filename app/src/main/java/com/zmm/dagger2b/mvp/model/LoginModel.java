package com.zmm.dagger2b.mvp.model;

import com.zmm.dagger2b.bean.BaseBean;
import com.zmm.dagger2b.bean.UserBean;
import com.zmm.dagger2b.http.ApiService;
import com.zmm.dagger2b.mvp.presenter.contract.LoginContract;

import io.reactivex.Observable;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/31
 * Email:65489469@qq.com
 */
public class LoginModel implements LoginContract.ILoginModel {

    private ApiService mApiService;

    public LoginModel(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<UserBean>> login(String phone, String password) {
        return mApiService.login(phone,password);
    }
}
