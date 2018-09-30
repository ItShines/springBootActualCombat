package com.springboot.ecs.cms.notify;

import com.alibaba.cms.cms.ProfileStatic;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

import java.util.List;

/**
 * 暂停一个应用分组的一个可用区的所有机器的报警。输入是分组ID，可以区ID，小时数N
 * @author wb-ryd460712
 */
public class createNotifyInstancePolicy {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile(ProfileStatic.regionId, ProfileStatic.accessKeyId, ProfileStatic.secret);
        IAcsClient client = new DefaultAcsClient(profile);
        String groupId = "1312507";
        String zoneId = "cn-beijing-a";
        int n = 1;
        try {
            //1.获取指定分组下的所有实例的Resources集合
            List<ListMyGroupInstancesDetailsResponse.Resource> resources = getListMyGroupInstancesDetails(groupId,client).getResources();
            for (int i = 0; i < resources.size(); i++) {
                ListMyGroupInstancesDetailsResponse.Resource resource = resources.get(i);
                //2.获取指定分组下的实例的可用区信息
                String availabilityZone = resource.getRegion().getAvailabilityZone();
                //3.判断是否属于要停止的可用区
                if (zoneId.equals(availabilityZone)) {
                    //4.根据实例名称获取属于ECS的所有的报警规则alarmList
                    List<ListAlarmResponse.Alarm> alarmList = getListAlarmResponse(resource,client).getAlarmList();
                    //5.创建暂停报警规则前删除该实例所有报警规则
                    boolean booleanDelete = deleteNotifyPolicy(groupId, resource, client);
                    if(booleanDelete){
                        for (int j = 0; j < alarmList.size(); j++) {
                            ListAlarmResponse.Alarm alarm = alarmList.get(j);
                            //6.创建暂停报警规则信息
                            CreateNotifyPolicyResponse policyResponse = createNotifyPolicy(groupId,resource,alarm,n,client);
                            System.out.println("Success:" + policyResponse.getSuccess());
                            System.out.println("ErrorCode:" + policyResponse.getCode());
                            System.out.println("ErrorMessage:" + policyResponse.getMessage());
                            System.out.println("RequestId:" + policyResponse.getRequestId());
                            System.out.println("result:" + policyResponse.getResult());
                        }
                    }
                }
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取指定分组下的所有实例
     */
    public static ListMyGroupInstancesDetailsResponse getListMyGroupInstancesDetails(String groupId,IAcsClient client) throws ClientException {
        ListMyGroupInstancesDetailsRequest listMyGroupInstancesDetails = new ListMyGroupInstancesDetailsRequest();
        listMyGroupInstancesDetails.setGroupId(Long.valueOf(groupId));
        return client.getAcsResponse(listMyGroupInstancesDetails);
    }

    /**
     * 根据实例名称获取属于ECS的所有的报警规则
     * @param resource
     * @param client
     * @return
     * @throws ClientException
     */
    public static ListAlarmResponse getListAlarmResponse(ListMyGroupInstancesDetailsResponse.Resource resource,IAcsClient client)throws ClientException{
        JSONObject dimension = new JSONObject();
        dimension.put("instacnce", resource.getInstanceName());
        ListAlarmRequest listAlarm = new ListAlarmRequest();
        listAlarm.setNamespace("acs_ecs_dashboard");
        listAlarm.setDimension(JSON.toJSONString(dimension));
        return client.getAcsResponse(listAlarm);
    }

    /**
     * 创建暂停报警信息
     * @param groupId
     * @param resource
     * @param alarm
     * @param n
     * @param client
     * @return
     * @throws ClientException
     */
    public static CreateNotifyPolicyResponse createNotifyPolicy(String groupId,ListMyGroupInstancesDetailsResponse.Resource resource,ListAlarmResponse.Alarm alarm,int n,IAcsClient client)throws ClientException{
        CreateNotifyPolicyRequest createNotifyPolicy = new CreateNotifyPolicyRequest();
        JSONObject dimensions = new JSONObject();
        dimensions.put("instanceId", resource.getInstanceId());
        createNotifyPolicy.setDimensions(JSON.toJSONString(dimensions));
        createNotifyPolicy.setAlertName(alarm.getName());
        createNotifyPolicy.setStartTime(System.currentTimeMillis());
        createNotifyPolicy.setEndTime(System.currentTimeMillis() + n * 1000 * 60);
        createNotifyPolicy.setPolicyType("PauseNotify");
        createNotifyPolicy.setGroupId(groupId);
        return client.getAcsResponse(createNotifyPolicy);
    }

    /**
     * 删除实例下的所有暂停报警规则
     * @param groupId
     * @param resource
     * @param client
     * @return
     * @throws ClientException
     */
    public static boolean deleteNotifyPolicy(String groupId,ListMyGroupInstancesDetailsResponse.Resource resource,IAcsClient client) throws ClientException {
        DeleteNotifyPolicyRequest deleteNotifyPolicy = new DeleteNotifyPolicyRequest();
        JSONObject object = new JSONObject();
        object.put("instanceId", resource.getInstanceId());
        //策略类型
        deleteNotifyPolicy.setPolicyType("PauseNotify");
        //分组Id
        deleteNotifyPolicy.setGroupId(groupId);
        DeleteNotifyPolicyResponse response = client.getAcsResponse(deleteNotifyPolicy);
        if(Boolean.TRUE.toString().equals(response.getSuccess())) {
            return true;
        }else{
            return false;
        }
    }
}
