package com.zmm.dagger2b;

import android.app.Application;
import android.content.Context;

import com.zmm.dagger2b.dagger.component.DaggerHttpComponent;
import com.zmm.dagger2b.dagger.component.HttpComponent;
import com.zmm.dagger2b.dagger.module.HttpModule;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/31
 * Email:65489469@qq.com
 */
public class MyApplication extends Application {

    private HttpComponent mHttpComponent;

    public HttpComponent getAppComponent() {
        return mHttpComponent;
    }

    public static MyApplication get(Context context){
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mHttpComponent = DaggerHttpComponent.builder().httpModule(new HttpModule()).build();

    }
}
