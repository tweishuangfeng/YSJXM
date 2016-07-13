package com.example.awit.ysjxm.interfacesimpl;


import android.app.Application;
import android.content.Context;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.awit.ysjxm.bean.FailRequest;
import com.example.awit.ysjxm.bean.Login;
import com.example.awit.ysjxm.bean.Organization;
import com.example.awit.ysjxm.dao.LoginInfo;
import com.example.awit.ysjxm.dao.OrganizationInfo;
import com.example.awit.ysjxm.global.GloBalUrl;
import com.example.awit.ysjxm.interfaces.HttpResultListener;
import com.example.awit.ysjxm.interfaces.OrganizationInter;
import com.example.awit.ysjxm.utils.ValueConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Lenvovo on 2016/6/23.
 */
public class organizationImpl implements OrganizationInter {

    private ArrayList<Organization.OrgData> arr;


    private String TAG = "organizationImpl";
    public   Organization organizationobj;
    private FailRequest failRequestobj;




    @Override
    public ArrayList<Organization.OrgData>  getorgTree(String userId, String orgId) {


        HttpUtils httpUtils = new HttpUtils();


        RequestParams params = new RequestParams();

        params.addBodyParameter("userId", userId);
        params.addBodyParameter("orgId", orgId);


        httpUtils.send(HttpRequest.HttpMethod.POST, GloBalUrl.Organization, params, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                JSONObject jsonObject;
                String data = null;


                try {

                    Gson gson = new Gson();


                    // JSON 数据格式转成单一实体对象和转换成对象列表或者其他结构
                    Organization organization = gson.fromJson(responseInfo.result, Organization.class);

                   String str = organization.toString();
                   jsonObject = new JSONObject(str);

                    if (Integer.parseInt(str) >1) {
                        failRequestobj = new FailRequest();
                        failRequestobj.setStatus(jsonObject.getString("status"));
                        failRequestobj.setMsg(jsonObject.getString("msg"));

                    }else {

                        String dataobj = jsonObject.getString("orgdata");
                        Log.i(TAG, dataobj);
                        JSONObject datao = new JSONObject(dataobj);


                        JSONArray dataarr = new JSONArray(datao.getString("list"));

                         arr = new ArrayList<Organization.OrgData>();
                        for (int i = 0; i < dataarr.length(); i++) {

                            try {
                                data = dataarr.get(i).toString();
                                jsonObject = new JSONObject(data);

                                Organization organization1=new Organization();
                                Organization.OrgData org2=organization1.new OrgData();

                                org2.setUserId(jsonObject.getString("userId"));
                                org2.setOrgid(jsonObject.getString("orgid"));
                                org2.setDepartlistid(jsonObject.getString("departlistid"));
                                org2.setDepartlistname(jsonObject.getString("departlistname"));

                                arr.add(org2);



                            }catch (Exception e){
                               System.out.println("Json parse error");
                                e.printStackTrace();
                            }

                          }


                        }
//
//                    JSONArray dataarr = new JSONArray(organization.getOrgdata());
//
//
//                    for (int i = 0; i < dataarr.length(); i++) {
//                        str= dataarr.get(i).toString();
//
//
//                        organizationobj= new Organization();
//                        organizationobj.setUserId(jsonObject.getString("UserId"));
//                        organizationobj.setOrgid(jsonObject.getString("orgid"));
//                        ArrayList<Organization.Data> datalist=new ArrayList<Organization.Data>();
//                        JSONArray jsonArr= jsonObject.getJSONArray("data");
//                        if(jsonArr.length()>0){
//                            for(int i=0;i<jsonArr.length();i++){
//                                Organization.Data d=new Data();
//                                d.se
//

                    }catch (Exception e){
                         e.printStackTrace();
                    }


            }





            @Override
            public void onFailure(HttpException e, String s) {

                Log.i(TAG, "接口数据获取失败:" + s);

            }


            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCancelled() {
                super.onCancelled();
            }

        });

        return arr;
    }


}
