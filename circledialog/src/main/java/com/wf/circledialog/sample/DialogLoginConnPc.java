package com.wf.circledialog.sample;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wf.circledialog.BaseCircleDialog;
import com.wf.circledialog.R;

/**
 * 登录界面未连接USB弹出的对话框
 * Created by wangpf on 2017/7/15.
 */
public class DialogLoginConnPc extends BaseCircleDialog implements View.OnClickListener {

    public static DialogLoginConnPc getInstance() {
        DialogLoginConnPc dialogFragment = new DialogLoginConnPc();
        dialogFragment.setCanceledBack(false);
        dialogFragment.setCanceledOnTouchOutside(false);
        return dialogFragment;
    }

    @Override
    public View createView(Context context, LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dialog_login_conn_pic, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
