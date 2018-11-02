package com.zmm.dagger2b;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zmm.dagger2b.bean.UserBean;
import com.zmm.dagger2b.dagger.component.DaggerLoginComponent;
import com.zmm.dagger2b.dagger.component.HttpComponent;
import com.zmm.dagger2b.dagger.module.LoginModule;
import com.zmm.dagger2b.http.ApiService;
import com.zmm.dagger2b.mvp.presenter.contract.LoginContract;

import javax.inject.Inject;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/11/2
 * Email:65489469@qq.com
 */
public class TestActivity extends AppCompatActivity implements LoginContract.LoginView{

    private final String TAG = TestActivity.class.getSimpleName();


    @Inject
    ApiService mApiService;

    @Inject
    ApiService mApiService2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);


        HttpComponent httpComponent = MyApplication.get(this).getAppComponent();

        DaggerLoginComponent
                .builder()
                .httpComponent(httpComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        Button btn1 = findViewById(R.id.btn_init_api2);
        Button back = findViewById(R.id.btn_back);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"mApiService = "+mApiService);
                Log.d(TAG,"mApiService2 = "+mApiService2);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void loginSuccess(UserBean userBean) {

    }

    @Override
    public void error(String s) {

    }
}
