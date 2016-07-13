package com.example.awit.ysjxm.interfacesimpl;

import android.preference.PreferenceActivity;
import android.util.Log;

import com.example.awit.ysjxm.bean.FailRequest;
import com.example.awit.ysjxm.bean.Organization;
import com.example.awit.ysjxm.bean.Unit;
import com.example.awit.ysjxm.dao.LoginInfo;
import com.example.awit.ysjxm.dao.UnitInfo;
import com.example.awit.ysjxm.global.GloBalUrl;
import com.example.awit.ysjxm.interfaces.HttpResultListener;
import com.example.awit.ysjxm.interfaces.UnitInter;
import com.example.awit.ysjxm.utils.ValueConfig;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenvovo on 2016/6/24.
 */
public class unitImpl  implements UnitInter {

    private String TAG = "unitImpl";

    private  ArrayList<Unit>  arr;

    private  Unit unit;
    private FailRequest failRequestobj;



    @Override
    public List<Unit> getunitinfo(String orgId) {



        HttpUtils httpUtils = new HttpUtils();


        RequestParams params = new RequestParams();

        params.addBodyParameter("orgId", orgId);


        httpUtils.send(HttpRequest.HttpMethod.POST, GloBalUrl.Unit, params, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                JSONObject jsonObject;
                String data = null;
                arr=new ArrayList<Unit>();

                try {

                    Gson gson = new Gson();


                    // JSON 数据格式转成单一实体对象和转换成对象列表或者其他结构
                   Unit unit= gson.fromJson(responseInfo.result,Unit.class);

                    String str = unit.toString();
                    jsonObject = new JSONObject(str);

                    if (Integer.parseInt(str) >1) {
                        failRequestobj = new FailRequest();
                        failRequestobj.setStatus(jsonObject.getString("status"));
                        failRequestobj.setMsg(jsonObject.getString("msg"));

                    }else {

                        String dataobj=jsonObject.getString("data");
                        Log.i(TAG, dataobj);
                        JSONObject datao=new JSONObject(dataobj);


                        JSONArray dataarr=new JSONArray(datao.getString("list"));

                        Log.i(TAG, dataarr.toString());


                        for (int j = 0; j < dataarr.length(); j++) {
                            data = dataarr.get(j).toString();
                            jsonObject = new JSONObject(data);
                            unit = new Unit();

                            unit.setUserid(jsonObject.getString("userid"));
                            unit.setOrgid(jsonObject.getString("orgid"));
                            unit.setParentdepartid(jsonObject.getString("parentdepartid"));
                            unit.setGrp_name(jsonObject.getString("grp_name"));
                            unit.setGrp_type(jsonObject.getString("grp_type"));
                            unit.setGrp_code(jsonObject.getString("grp_code"));
                            unit.setD_group_id(jsonObject.getString("d_group_id"));
                            arr.add(unit);

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






