package com.wf.pattern.mvp.presenter;

import com.wf.utils.StringUtils;
import com.wf.pattern.mvp.model.ILoginNet;
import com.wf.pattern.mvp.model.LoginNet;
import com.wf.pattern.mvp.model.RespInfo;
import com.wf.pattern.mvp.model.User;
import com.wf.pattern.mvp.view.ILoginView;

/**
 * MVP的Presenter层，专门处理业务
 * Created by wangpf on 2017/3/4.
 */

public class LoginPresenter {
    private ILoginView view;
    private ILoginNet model;
    public LoginPresenter(ILoginView view) {
        this.view = view;
        this.model = new LoginNet();
    }

    /**
     * 用户登陆
     * @param user
     */
    public void login(final User user) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                RespInfo resp = model.appLogin(user);
                if("true".equals(resp.getSuccess())) {//登录OK
                    view.loginSuccess();
                }else {
                    view.loginFail(resp.getMessage());
                }
            }
        };
        thread.start();
    }

    /**
     * 检查用户名、密码是否为空
     * @param user
     * @return
     */
    public boolean checkUser(User user) {
        if(StringUtils.isEmpty(user.getUsername())
                || StringUtils.isEmpty(user.getPassword())) {
            return false;
        }
        return true;
    }
}
