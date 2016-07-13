package com.example.awit.ysjxm.interfaces;

import com.example.awit.ysjxm.bean.Survey;

import java.util.List;

/**
 * Created by Lenvovo on 2016/6/30.
 *
 * 实时监测接口
 */
public interface SurveyInter {

    public List<Survey> getSurveyData(String groupId);
}
