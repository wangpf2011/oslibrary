package com.wf.circledialog.sample;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wf.circledialog.BaseCircleDialog;
import com.wf.circledialog.R;

/**
 * 注销框
 * Created by wangpf on 2017/7/15.
 */
public class DialogLogout extends BaseCircleDialog implements View.OnClickListener {

    public static DialogLogout getInstance() {
        DialogLogout dialogFragment = new DialogLogout();
        dialogFragment.setCanceledBack(false);
        dialogFragment.setCanceledOnTouchOutside(false);
        dialogFragment.setGravity(Gravity.BOTTOM);
        dialogFragment.setWidth(1f);
        return dialogFragment;
    }

    @Override
    public View createView(Context context, LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dialog_logout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        view.findViewById(R.id.but_cancle).setOnClickListener(this);
        view.findViewById(R.id.logout_ok).setOnClickListener(this);
        view.findViewById(R.id.logout_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logout_ok) {
            //注销逻辑
        } else {
            dismiss();
        }
    }

}
