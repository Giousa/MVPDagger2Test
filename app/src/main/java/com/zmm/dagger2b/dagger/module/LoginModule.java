package com.zmm.dagger2b.dagger.module;

import com.zmm.dagger2b.http.ApiService;
import com.zmm.dagger2b.mvp.model.LoginModel;
import com.zmm.dagger2b.mvp.presenter.contract.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/31
 * Email:65489469@qq.com
 */
@Module
public class LoginModule {

    private LoginContract.LoginView mLoginView;

    public LoginModule(LoginContract.LoginView loginView) {
        mLoginView = loginView;
    }

    @Provides
    public LoginContract.LoginView provideLoginView(){

        return mLoginView;
    }

    @Provides
    public LoginContract.ILoginModel provideLoginModel(ApiService apiService){

        return new LoginModel(apiService);
    }


}
