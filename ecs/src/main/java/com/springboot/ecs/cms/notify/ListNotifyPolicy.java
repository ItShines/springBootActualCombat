package com.springboot.ecs.cms.notify;

import com.alibaba.cms.cms.ProfileStatic;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.ListNotifyPolicyRequest;
import com.aliyuncs.cms.model.v20180308.ListNotifyPolicyResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 查询暂停报警规则列表 -- ListNotifyPolicy
 * @author wb-ryd460712
 */
public class ListNotifyPolicy {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile(ProfileStatic.regionId, ProfileStatic.accessKeyId, ProfileStatic.secret);
        IAcsClient client = new DefaultAcsClient(profile);

        ListNotifyPolicyRequest listNotifyPolicy = new ListNotifyPolicyRequest();
        //RegionId String 非必选 地域Id
        listNotifyPolicy.setRegionId("cn-beijing");
        //AlertName String 可选 已暂停通知的报警规则名称
//        listNotifyPolicy.setAlertName("agent_heartbeat_stopped");
        //Id String 可选 已暂停通知的报警规则策略Id
        listNotifyPolicy.setId(null);
        //PageSize Integer 可选 每页大小
        listNotifyPolicy.setPageSize(30);
        //PolicyType String 必选必填 策略类型
        listNotifyPolicy.setPolicyType("PauseNotify");
        JSONObject dimensions = new JSONObject();
        dimensions.put("instanceId", "i-2zehwry4r1spt5s6abrb");
        //维度 jsonString 可选 实例Id
        listNotifyPolicy.setDimensions(JSON.toJSONString(dimensions));
        //GroupId String 可选 分组Id
        listNotifyPolicy.setGroupId("1312507");

        try {
            ListNotifyPolicyResponse response = client.getAcsResponse(listNotifyPolicy);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getCode());
            System.out.println("ErrorMessage:" + response.getMessage());
            System.out.println("RequestId:" + response.getRequestId());
            response.getNotifyPolicyList().forEach(notifyPolicy -> System.out.println("NotifyPolicy:"+JSON.toJSONString(notifyPolicy)));
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
