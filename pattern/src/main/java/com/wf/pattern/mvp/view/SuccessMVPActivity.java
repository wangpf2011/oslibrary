package com.wf.pattern.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wf.common.ActivityCollection;
import com.wf.common.BaseActivity;
import com.wf.pattern.R;

/**
 * 登陆成功显示页面
 * Created by wangpf on 2017/2/28.
 */

public class SuccessMVPActivity extends BaseActivity {
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_success);
        title = (TextView) this.findViewById(R.id.txt_title);
        title.setText("登陆成功");
    }

    /**
     * 返回
     * @param view
     */
    public void backBtn(View view) {
        ActivityCollection.getInstance().removeActivity(this);
        this.finish();
    }
}
