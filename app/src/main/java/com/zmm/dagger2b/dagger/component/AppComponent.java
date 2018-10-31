package com.zmm.dagger2b.dagger.component;

import android.app.Application;

import com.zmm.dagger2b.dagger.module.AppModule;
import com.zmm.dagger2b.dagger.module.HttpModule;
import com.zmm.dagger2b.http.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/31
 * Email:65489469@qq.com
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    //将HttpModule中的ApiService暴露出来，以便于其他依赖于AppComponent的Component调用
    ApiService getApiService();

    Application getApplication();

}

