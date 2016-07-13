package com.example.awit.ysjxm.interfaces;

import com.example.awit.ysjxm.bean.Organization;

import java.util.ArrayList;

/**
 * Created by Lenvovo on 2016/6/23.
 */
public interface OrganizationInter {


    public ArrayList<Organization.OrgData> getorgTree(String userId, String orgId);

}
