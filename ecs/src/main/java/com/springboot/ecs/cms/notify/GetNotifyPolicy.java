package com.springboot.ecs.cms.notify;

import com.alibaba.cms.cms.ProfileStatic;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.GetNotifyPolicyRequest;
import com.aliyuncs.cms.model.v20180308.GetNotifyPolicyResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * GetNotifyPolicy 获取暂停报警规则详情 无则404
 * @author wb-ryd460712
 */
public class GetNotifyPolicy {

    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile(ProfileStatic.regionId, ProfileStatic.accessKeyId, ProfileStatic.secret);
        IAcsClient client = new DefaultAcsClient(profile);

        GetNotifyPolicyRequest getNotifyPolicy = new GetNotifyPolicyRequest();
        //RegionId String 非必选 地域Id
        getNotifyPolicy.setRegionId("cn-beijing");
        JSONObject object = new JSONObject();
        object.put("instanceId", "i-2zehwry4r1spt5s6abrb");
        //维度 jsonString 可选 实例Id
        getNotifyPolicy.setDimensions(JSON.toJSONString(object));
        //Id String 可选 已暂停通知的报警规则策略Id
        getNotifyPolicy.setId(null);
        //PolicyType String 必选必填 策略类型
        getNotifyPolicy.setPolicyType("PauseNotify");
        //AlertName String 可选 已暂停通知的报警规则名称
        getNotifyPolicy.setAlertName("memory_usedutilization_90.0");
        //GroupId String 可选 分组Id
        getNotifyPolicy.setGroupId("1312507");

        try {
            GetNotifyPolicyResponse response = client.getAcsResponse(getNotifyPolicy);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getCode());
            System.out.println("ErrorMessage:" + response.getMessage());
            System.out.println("RequestId:" + response.getRequestId());
            System.out.println("result:" + JSON.toJSONString(response.getResult()));
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
