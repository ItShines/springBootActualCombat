package com.springboot.ecs.cms;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.cms.model.v20180308.ListMyGroupsRequest;
import com.aliyuncs.cms.model.v20180308.ListMyGroupsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class CmsController {
    public static void main(String[] args) {
        String endpoint = "sts.aliyuncs.com";
        String regionId = "cn-hangzhou";
        String accessKeyId = "LTAIkLRbDKfBdkip";
        String accessKeySecret = "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo";
        String roleArn = "acs:ram::1087477042505994:role/cms";
        String roleSessionName = "session-name";
        try {
            // 1. 获取 STS Token
            DefaultProfile.addEndpoint(regionId, regionId, "Sts", endpoint);
            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setPolicy(null); // 可选，此处可以填写为NULL
            final AssumeRoleResponse response = client.getAcsResponse(request);

            // 2. 查询应用分组列表
            // 初始化
            DefaultProfile profile1 = DefaultProfile.getProfile(regionId, response.getCredentials().getAccessKeyId(),
                    response.getCredentials().getAccessKeySecret(), response.getCredentials().getSecurityToken());
            IAcsClient client1 = new DefaultAcsClient(profile1);

            // 设置参数
            ListMyGroupsRequest listMyGroups = new ListMyGroupsRequest();

            // 发起请求
            ListMyGroupsResponse response1 = client1.getAcsResponse(listMyGroups);
            System.out.println("Success:" + response1.getSuccess());
            System.out.println("ErrorCode:" + response1.getErrorCode());
            System.out.println("ErrorMessage:" + response1.getErrorMessage());
            System.out.println("RequestId:" + response1.getRequestId());
            System.out.println("PageNumber:" + response1.getPageNumber());
            System.out.println("PageSize:" + response1.getPageSize());
            System.out.println("Total:" + response1.getTotal());
            System.out.println("Resources:" + JSON.toJSONString(response1.getResources()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
