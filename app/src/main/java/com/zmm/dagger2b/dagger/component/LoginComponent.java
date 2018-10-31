package com.zmm.dagger2b.dagger.component;

import com.zmm.dagger2b.MainActivity;
import com.zmm.dagger2b.dagger.ActivityScope;
import com.zmm.dagger2b.dagger.module.LoginModule;

import dagger.Component;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/31
 * Email:65489469@qq.com
 */
@ActivityScope
@Component(modules = LoginModule.class,dependencies = AppComponent.class)
public interface LoginComponent {

    void inject(MainActivity activity);
}
