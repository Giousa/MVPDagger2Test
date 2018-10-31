package com.zmm.dagger2b;

import android.app.Application;
import android.content.Context;

import com.zmm.dagger2b.dagger.component.AppComponent;
import com.zmm.dagger2b.dagger.component.DaggerAppComponent;
import com.zmm.dagger2b.dagger.module.AppModule;
import com.zmm.dagger2b.dagger.module.HttpModule;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/31
 * Email:65489469@qq.com
 */
public class MyApplication extends Application {

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static MyApplication get(Context context){
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().httpModule(new HttpModule()).appModule(new AppModule(this)).build();

    }
}
