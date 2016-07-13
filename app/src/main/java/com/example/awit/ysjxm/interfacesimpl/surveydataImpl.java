package com.example.awit.ysjxm.interfacesimpl;

import android.util.Log;

import com.example.awit.ysjxm.bean.Survey;
import com.example.awit.ysjxm.bean.FailRequest;
import com.example.awit.ysjxm.global.GloBalUrl;
import com.example.awit.ysjxm.interfaces.SurveyInter;
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
 * Created by Lenvovo on 2016/6/28.
 *
 *
 * 实时监测实现类
 */
public class surveydataImpl implements SurveyInter {

    private String TAG = "surveyImpl";

    private  ArrayList<Survey>  arr;

    private Survey surveyData;
    private FailRequest failRequestobj;



    @Override
    public List<Survey> getSurveyData(String groupId) {

        arr=new ArrayList<Survey>();


        HttpUtils httpUtils = new HttpUtils();


        RequestParams params = new RequestParams();

        params.addBodyParameter("groupId", groupId);


        httpUtils.send(HttpRequest.HttpMethod.POST, GloBalUrl.SurveyData, params, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                JSONObject jsonObject;
                String data = null;
                try {

                    Gson gson = new Gson();


                    // JSON 数据格式转成单一实体对象和转换成对象列表或者其他结构
                   Survey surveyData = gson.fromJson(responseInfo.result, Survey.class);

                    String str = surveyData.toString();
                    jsonObject = new JSONObject(str);

                    if (Integer.parseInt(str) >1) {
                        failRequestobj = new FailRequest();
                        failRequestobj.setStatus(jsonObject.getString("status"));
                        failRequestobj.setMsg(jsonObject.getString("msg"));
//                        arr.add(failRequestobj);

                    }else {

                        String dataobj=jsonObject.getString("surveydata");
                        Log.i(TAG, dataobj);
                        JSONObject datao=new JSONObject(dataobj);


                        JSONArray dataarr=new JSONArray(datao.getString("list"));

                        Log.i(TAG, dataarr.toString());

                        for (int j = 0; j < dataarr.length(); j++) {
                            data = dataarr.get(j).toString();
                            jsonObject = new JSONObject(data);
                            surveyData = new Survey();

                            surveyData.setT_s_depratid(jsonObject.getString("t_s_depratid"));
                            surveyData.setDepartname(jsonObject.getString("departname"));
                            surveyData.setGrp_type(jsonObject.getString("grp_type"));
                            surveyData.setGrp_name(jsonObject.getString("grp_name"));
                            surveyData.setD_group_id(jsonObject.getString("d_group_id"));
                            surveyData.setDty_code(jsonObject.getString("  dty_code"));
                            surveyData.setD_type_id(jsonObject.getString("d_type_id"));
                            surveyData.setDty_name(jsonObject.getString("dty_name"));
                            surveyData.setD_value(jsonObject.getString(" d_value"));
                            surveyData.setD_valuemin(jsonObject.getString(" d_valuemin"));
                            surveyData.setD_valuemax(jsonObject.getString("d_valuemax"));
                            surveyData.setD_time(jsonObject.getString("d_time "));

                            arr.add(surveyData);
                        }

                    }

                 }catch (Exception e){

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
