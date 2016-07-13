package com.example.awit.ysjxm.interfacesimpl;

import android.util.Log;

import com.example.awit.ysjxm.bean.Alarm;
import com.example.awit.ysjxm.bean.FailRequest;
import com.example.awit.ysjxm.bean.Survey;
import com.example.awit.ysjxm.global.GloBalUrl;
import com.example.awit.ysjxm.interfaces.AlarmInter;
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
 * Created by Lenvovo on 2016/6/30.
 */
public class alarmImpl   implements AlarmInter {



    private String TAG = "alarmImpl";

    private ArrayList<Alarm> arr;

    private Alarm alarmData;
    private FailRequest failRequestobj;



    @Override
    public List<Alarm> getAlarmData(String groupId) {


        HttpUtils httpUtils = new HttpUtils();


        RequestParams params = new RequestParams();

        params.addBodyParameter("groupId", groupId);


        httpUtils.send(HttpRequest.HttpMethod.POST, GloBalUrl.AlarmData, params, new RequestCallBack<String>() {


            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                JSONObject jsonObject;
                String data = null;
                try {

                    Gson gson = new Gson();


                    // JSON 数据格式转成单一实体对象和转换成对象列表或者其他结构
                    alarmData = gson.fromJson(responseInfo.result, Alarm.class);

                    String str = alarmData.toString();
                    jsonObject = new JSONObject(str);

                    if (Integer.parseInt(str) > 1) {
                        failRequestobj = new FailRequest();
                        failRequestobj.setStatus(jsonObject.getString("status"));
                        failRequestobj.setMsg(jsonObject.getString("msg"));


                    } else {

                        String dataobj = jsonObject.getString("alarmdata");
                        Log.i(TAG, dataobj);
                        JSONObject datao = new JSONObject(dataobj);


                        JSONArray dataarr = new JSONArray(datao.getString("list"));

                        Log.i(TAG, dataarr.toString());

                        for (int j = 0; j < dataarr.length(); j++) {
                            data = dataarr.get(j).toString();
                            jsonObject = new JSONObject(data);
                            alarmData = new Alarm();


                            alarmData.setGrp_type(jsonObject.getString("grp_type"));
                            alarmData.setGrp_code(jsonObject.getString("grp_code"));
                            alarmData.setGrp_name(jsonObject.getString(" grp_name"));
                            alarmData.setWar_group_id(jsonObject.getString("war_group_id"));
                            alarmData.setWar_title(jsonObject.getString("war_title"));
                            alarmData.setWar_name(jsonObject.getString("war_name"));
                            alarmData.setWar_content(jsonObject.getString("war_content"));


                            arr.add(alarmData);
                        }

                    }

                } catch (Exception e) {

                    e.printStackTrace();
                    System.out.println("Json parse error");
                }


            }


            @Override
            public void onFailure(HttpException e, String s) {

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



        return  arr;
      }




}