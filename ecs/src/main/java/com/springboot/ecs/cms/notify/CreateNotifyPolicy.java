package com.springboot.ecs.cms.notify;

import com.alibaba.cms.cms.ProfileStatic;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.CreateNotifyPolicyRequest;
import com.aliyuncs.cms.model.v20180308.CreateNotifyPolicyResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 创建暂停通知报警规则接口 -- CreateNotifyPolicy
 * @author wb-ryd460712
 */
public class CreateNotifyPolicy {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile(ProfileStatic.regionId, ProfileStatic.accessKeyId, ProfileStatic.secret);
        IAcsClient client = new DefaultAcsClient(profile);
        //可选参数均可不填写，但是只是产生一条记录，能不能正常使用未可知，且云监控控制台无法正常显示记录
        CreateNotifyPolicyRequest createNotifyPolicy = new CreateNotifyPolicyRequest();
        //RegionId String 非必选 地域Id，有默认值
        createNotifyPolicy.setRegionId("cn-beijing");
        //AlertName String 可选 需要暂停的报警规则名称
        createNotifyPolicy.setAlertName("agent_heartbeat_stopped");
        //StartTime Long 可选 暂停报警开始时间
        createNotifyPolicy.setStartTime(System.currentTimeMillis());
        //EndTime Long 可选 暂停报警结束时间
        createNotifyPolicy.setEndTime(System.currentTimeMillis()+30*1000*60);
        //PolicyType String 必选必填 暂停报警的策略类型 选择PauseNotify
        createNotifyPolicy.setPolicyType("PauseNotify");
        JSONObject dimensions = new JSONObject();
        dimensions.put("instanceId", "i-2zehwry4r1spt5s6abrb");
        //Dimensions String 可选 实例Id
        createNotifyPolicy.setDimensions(JSON.toJSONString(dimensions));
        //GroupId String 可选 暂停报警的所在实例分组Id
        createNotifyPolicy.setGroupId("1312507");

        // 发起请求
        try {
            CreateNotifyPolicyResponse response = client.getAcsResponse(createNotifyPolicy);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getCode());
            System.out.println("ErrorMessage:" + response.getMessage());
            System.out.println("RequestId:" + response.getRequestId());
            System.out.println("result:" + response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
