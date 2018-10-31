package com.zmm.dagger2b;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zmm.dagger2b.bean.UserBean;
import com.zmm.dagger2b.dagger.component.HttpComponent;
import com.zmm.dagger2b.dagger.component.DaggerLoginComponent;
import com.zmm.dagger2b.dagger.module.LoginModule;
import com.zmm.dagger2b.mvp.presenter.LoginPresenter;
import com.zmm.dagger2b.mvp.presenter.contract.LoginContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginContract.LoginView {


    @Inject
    LoginPresenter mLoginPresenter;


    @BindView(R.id.et_login_phone)
    EditText etLoginPhone;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.tv_content)
    TextView tvContent;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = this;

        HttpComponent httpComponent = MyApplication.get(this).getAppComponent();

        DaggerLoginComponent
                .builder()
                .httpComponent(httpComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);


    }

    @Override
    public void loginSuccess(UserBean userBean) {
        Toast.makeText(mContext, userBean.toString(), Toast.LENGTH_SHORT).show();

        tvContent.setText(userBean.toString());
    }

    @Override
    public void error(String s) {
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();

        tvContent.setText(s);
    }

    @OnClick(R.id.tv_login_enter)
    public void onViewClicked() {

        String phone = etLoginPhone.getText().toString();
        String password = etLoginPassword.getText().toString();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(mContext, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(mContext, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        mLoginPresenter.login(phone, password);
    }
}
