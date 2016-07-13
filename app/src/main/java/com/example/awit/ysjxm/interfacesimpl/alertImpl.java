package com.example.awit.ysjxm.interfacesimpl;

import android.util.Log;

import com.example.awit.ysjxm.bean.Alarm;
import com.example.awit.ysjxm.bean.Alert;
import com.example.awit.ysjxm.bean.FailRequest;
import com.example.awit.ysjxm.global.GloBalUrl;
import com.example.awit.ysjxm.interfaces.AlarmInter;
import com.example.awit.ysjxm.interfaces.AlertInter;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenvovo on 2016/7/12.
 */
public class alertImpl implements AlertInter {


    private String TAG = "alertImpl";

    private ArrayList<Alert> arr;

    private Alert alertData;
    private FailRequest failRequestobj;


    @Override
    public List<Alert> getAlertData(String groupId) {

        HttpUtils httpUtils = new HttpUtils();


        RequestParams params = new RequestParams();

        params.addBodyParameter("groupId", groupId);


        httpUtils.send(HttpRequest.HttpMethod.POST, GloBalUrl.AlertData, params, new RequestCallBack<String>() {


            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                JSONObject jsonObject;
                String data = null;
                try {

                    Gson gson = new Gson();


                    // JSON 数据格式转成单一实体对象和转换成对象列表或者其他结构
                    alertData = gson.fromJson(responseInfo.result, Alert.class);

                    String str = alertData.toString();
                    jsonObject = new JSONObject(str);

                    if (Integer.parseInt(str) > 1) {
                        failRequestobj = new FailRequest();
                        failRequestobj.setStatus(jsonObject.getString("status"));
                        failRequestobj.setMsg(jsonObject.getString("msg"));


                    } else {

                        String dataobj = jsonObject.getString("alertdata");
                        Log.i(TAG, dataobj);
                        JSONObject datao = new JSONObject(dataobj);


                        JSONArray dataarr = new JSONArray(datao.getString("list"));

                        Log.i(TAG, dataarr.toString());

                        for (int j = 0; j < dataarr.length(); j++) {
                            data = dataarr.get(j).toString();
                            jsonObject = new JSONObject(data);
                            alertData = new Alert();

                            alertData.setGrp_type(jsonObject.getString("grp_type"));
                            alertData.setGrp_code(jsonObject.getString(" grp_code"));
                            alertData.setGrp_name(jsonObject.getString(" grp_name"));
                            alertData.setWar_group_id(jsonObject.getString("war_group_id"));
                            alertData.setPwar_title(jsonObject.getString(" pwar_title"));
                            alertData.setPwar_name(jsonObject.getString(" pwar_name"));
                            alertData.setWar_content(jsonObject.getString(" war_content"));


                        }
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                    System.out.println("Json parse error");
                }
            }


            @Override
            public void onFailure(HttpException e, String s) {}

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
