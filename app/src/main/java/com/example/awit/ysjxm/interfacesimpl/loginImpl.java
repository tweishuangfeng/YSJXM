package com.example.awit.ysjxm.interfacesimpl;

import android.util.Log;
import android.widget.Toast;

import com.example.awit.ysjxm.bean.FailRequest;
import com.example.awit.ysjxm.bean.Login;
import com.example.awit.ysjxm.bean.Organization;
import com.example.awit.ysjxm.dao.LoginInfo;
import com.example.awit.ysjxm.global.GloBalUrl;
import com.example.awit.ysjxm.interfaces.HttpResultListener;
import com.example.awit.ysjxm.interfaces.LoginInter;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 * Created by Lenvovo on 2016/6/23.
 */
public class loginImpl implements LoginInter {

    private String TAG = "loginImpl";
    private Login login;
    private FailRequest failRequestobj;

    public loginImpl(HttpResultListener httpResultListener) {

    }


    @Override
    public  Login  getLogininfo(String account, String password) {

        HttpUtils httpUtils = new HttpUtils();


        RequestParams params = new RequestParams();

        params.addBodyParameter("account", account);
        params.addBodyParameter("password", password);


        httpUtils.send(HttpRequest.HttpMethod.POST, GloBalUrl.Login, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                Gson gson = new Gson();


                // JSON 数据格式转成单一实体对象和转换成对象列表或者其他结构


                login = gson.fromJson(responseInfo.result, Login.class);
                Log.e("people", responseInfo.result);



                try {
                    String str = login.toString();
                   JSONObject jsonObject = new JSONObject(str);


                    login.setUserid(jsonObject.getString(" userid"));
                    login.setStatus(jsonObject.getString("status"));
                    login.setMsg(jsonObject.getString("msg"));

                }catch (Exception e){

                    e.printStackTrace();
                }


            }



            @Override
            public void onFailure(HttpException e, String s) {

                if(login.getStatus().equals("1")){

                    login.setMsg("1: 登陆成功");

                }else if(login.getStatus().equals("2")){


                    login.setMsg("2: 登陆失败");

                } if(login.getStatus().equals("3")){


                    login.setMsg("3: 无网络");

                }


            }


        });

        return  login;


    }


}
