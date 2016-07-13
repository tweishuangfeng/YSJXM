package com.example.awit.ysjxm.global;

/**
 * Created by Lenvovo on 2016/6/27.
 */
public class GloBalUrl {

    public static String Login = "192.168.1.167:8080/acmonitor/appLogin.do?login&account=admin&password=123456";
    public static String  Organization  = "http://192.168.1.167:8080/acmonitor/appDepart.do?getDepartByUserIdAndOrgId&userId=8a8ab0b246dc81120146dc81819d0053 ";
    public static String  Unit  = "http://192.168.1.167:8080/acmonitor/appGroups.do?getGroupsByUserIdAndParentdepartid&orgId=4028819755959f3f015595b8a8a70010 ";
    public static String  SurveyData  = "http://192.168.1.167:8080/acmonitor/appDatas.do?getACDatasByUserIdAndGroupId&groupId=40287d81557c549401557c8045310012 ";
    public static String  AlarmData  = "http://192.168.1.167:8080/acmonitor/appWarnning.do?getWarnningByUserIdAndDTypeId&groupId=40287d81557c549401557c8045310012 ";
    public static String  AlertData  = "http://192.168.1.167:8080/acmonitor/appPreWarning.do?getPreWarnningByGroupId&groupId=4028812755cd2cc60155cd3382460002 ";

}
