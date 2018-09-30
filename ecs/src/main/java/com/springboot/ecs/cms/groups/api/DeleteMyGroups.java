package com.springboot.ecs.cms.groups.api;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.DeleteMyGroupsRequest;
import com.aliyuncs.cms.model.v20180308.DeleteMyGroupsResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 删除应用分组-DeleteMyGroups
 * @author wb-ryd460712
 */
public class DeleteMyGroups {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        //设置参数
        DeleteMyGroupsRequest deleteMyGroups = new DeleteMyGroupsRequest();
        //RegionId String 非必选 区域
        deleteMyGroups.setRegionId("cn-beijing");
        //GroupId Long 必选 分组Id
        deleteMyGroups.setGroupId(1328130L);

        // 发起请求
        try {
            DeleteMyGroupsResponse response = client.getAcsResponse(deleteMyGroups);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getErrorCode());
            System.out.println("ErrorMessage:" + response.getErrorMessage());
            System.out.println("RequestId:" + response.getRequestId());
            System.out.println("Group:" + JSON.toJSONString(response.getGroup()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
