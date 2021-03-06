package com.wf.pattern.mvc;

import android.util.Log;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.client.HttpRequest;
import com.wf.common.utils.HttpCookieStore;

import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * MVC的Model层
 * Created by wangpf on 2017/2/28.
 */

public class LoginNet {
    /**
     * 用户登陆
     *
     * 同步请求
     * @param user
     * @return RespInfo
     */
    public RespInfo appLogin(User user) {
        String https = "http://139.129.196.51/evcg2/";
        RespInfo resp = new RespInfo();

        RequestParams params = new RequestParams();
        params.addBodyParameter("username", user.getUsername());
        params.addBodyParameter("password", user.getPassword());
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10); //设置超时时间
        try {
            ResponseStream responseStream = http.sendSync(HttpRequest.HttpMethod.POST ,
                    https + "app/login",
                    params);
            String msg = responseStream.readString();
            JSONObject jsonObject = new JSONObject(msg);
            String success = jsonObject.getString("success");
            if("true".equals(success)) {//登录OK
                resp.setSuccess("true");
                DefaultHttpClient dh = (DefaultHttpClient)http.getHttpClient();
                HttpCookieStore.cookieStore = dh.getCookieStore();
            }else {
                resp.setSuccess("false");
                resp.setMessage(jsonObject.getString("message"));
            }
        } catch (Exception e) {
            resp.setSuccess("false");
            resp.setMessage("JSONObject resolve exception");
            Log.e("bluetooth", "JSONObject resolve exception");
            e.printStackTrace();
        }

        return resp;
    }
}
