package com.zmm.dagger2b.mvp.presenter.contract;

import com.zmm.dagger2b.bean.BaseBean;
import com.zmm.dagger2b.bean.UserBean;
import com.zmm.dagger2b.mvp.view.BaseView;

import io.reactivex.Observable;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/31
 * Email:65489469@qq.com
 */
public interface LoginContract {


    interface ILoginModel{
        Observable<BaseBean<UserBean>> login(String phone, String password);

    }


    interface LoginView extends BaseView{

        void loginSuccess(UserBean userBean);
    }

}
