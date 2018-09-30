package com.springboot.ecs.cms.groups.api;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.DeleteMyGroupInstancesRequest;
import com.aliyuncs.cms.model.v20180308.DeleteMyGroupInstancesResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author wb-ryd460712
 */
public class DeleteMyGroupInstances {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        //设置参数
        DeleteMyGroupInstancesRequest deleteMyGroupInstances = new DeleteMyGroupInstancesRequest();
        //RegionId String 非必选 区域
        deleteMyGroupInstances.setRegionId("cn-beijing");
        //GroupId String 必选 分组的ID
        deleteMyGroupInstances.setGroupId(1328130L);
        //InstanceIds String 非必选 这里的id是指ListMyGroupInstances接口返回的ID字段, 移除多个实例可以使用英文的逗号分隔
        deleteMyGroupInstances.setInstanceIds("i-2zehwry4r1spt5s6abrb");
        //指实例id列表，如i-xxxxx格式，多个实例用逗号隔开
        deleteMyGroupInstances.setInstanceIdList("i-2zehwry4r1spt5s6abrb");

        // 发起请求
        try {
            DeleteMyGroupInstancesResponse response = client.getAcsResponse(deleteMyGroupInstances);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getErrorCode());
            System.out.println("ErrorMessage:" + response.getErrorMessage());
            System.out.println("RequestId:" + response.getRequestId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
