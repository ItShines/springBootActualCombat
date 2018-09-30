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
public class CreateNotifyInstancesPolicy {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile(ProfileStatic.regionId, ProfileStatic.accessKeyId, ProfileStatic.secret);
        IAcsClient client = new DefaultAcsClient(profile);
        String groupId = "1312507";
        String zoneId = "cn-beijing-a";
        int n = 1;
        int pageNumber =1;
        int pageSize =30;
        try {
            //获取指定分组下的所有实例的Resources集合
            ListMyGroupInstancesDetailsResponse instancesDetails = getListMyGroupInstancesDetails(groupId,pageNumber,pageSize,client);
            if(instancesDetails.getTotal()>pageSize){
                pageSize = instancesDetails.getTotal();
                instancesDetails = getListMyGroupInstancesDetails(groupId, pageNumber, pageSize, client);
            }
            List<ListMyGroupInstancesDetailsResponse.Resource> resources =instancesDetails.getResources();
            for (int i = 0; i < resources.size(); i++) {
                ListMyGroupInstancesDetailsResponse.Resource resource = resources.get(i);
                //获取指定分组下的实例的可用区信息
                String availabilityZone = resource.getRegion().getAvailabilityZone();
                //判断是否属于要停止的可用区
                if (zoneId.equals(availabilityZone)) {
                    //根据实例名称获取属于ECS的所有的报警规则alarmList
                    pageSize =100;
                    ListAlarmResponse listAlarmResponse = getListAlarmResponse(pageNumber,pageSize,resource, client);
                    if(!"null".equals(listAlarmResponse.getNextToken())){
                        listAlarmResponse = getListAlarmResponse(pageNumber,listAlarmResponse.getTotal(),resource, client);
                    }
                    List<ListAlarmResponse.Alarm> alarmList = listAlarmResponse.getAlarmList();
                    for (int j = 0; j < alarmList.size(); j++) {
                        ListAlarmResponse.Alarm alarm = alarmList.get(j);
                        ListNotifyPolicyResponse notifyPolicyResponse = listNotifyPolicy(groupId,alarm,resource,client);
                        //创建暂停报警规则信息
                        CreateNotifyPolicyResponse policyResponse = createNotifyPolicy(groupId,resource,alarm,n,client);
                        System.out.println("Success:" + policyResponse.getSuccess());
                        System.out.println("ErrorCode:" + policyResponse.getCode());
                        System.out.println("ErrorMessage:" + policyResponse.getMessage());
                        System.out.println("RequestId:" + policyResponse.getRequestId());
                        System.out.println("result:" + policyResponse.getResult());
                        if(Boolean.TRUE.toString().equals(policyResponse.getSuccess()) && Boolean.TRUE.toString().equals(notifyPolicyResponse.getSuccess()) && notifyPolicyResponse.getNotifyPolicyList().size()>0){
                            //创建暂停报警规则前删除该实例所有报警规则
                            JSONObject dimensions = new JSONObject();
                            dimensions.put("instanceId",resource.getInstanceId());
                            notifyPolicyResponse.getNotifyPolicyList().forEach(notifyPolicyItem -> {
                                if(notifyPolicyItem.getDimensions().equals(JSON.toJSONString(dimensions))){
                                    try {
                                        boolean booleanDelete = deleteNotifyPolicy(notifyPolicyItem, client);
                                        System.out.println(booleanDelete);
                                    } catch (ClientException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
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
    public static ListMyGroupInstancesDetailsResponse getListMyGroupInstancesDetails(String groupId,int pageNumber,int pageSize,IAcsClient client) throws ClientException {
        ListMyGroupInstancesDetailsRequest listMyGroupInstancesDetails = new ListMyGroupInstancesDetailsRequest();
        listMyGroupInstancesDetails.setRegionId("cn-beijing");
        listMyGroupInstancesDetails.setTotal(true);
        listMyGroupInstancesDetails.setPageNumber(pageNumber);
        listMyGroupInstancesDetails.setPageSize(pageSize);
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
    public static ListAlarmResponse getListAlarmResponse(int pageNumber,int pageSize,ListMyGroupInstancesDetailsResponse.Resource resource,IAcsClient client)throws ClientException{
        JSONObject dimension = new JSONObject();
        dimension.put("instacnce", resource.getInstanceName());
        ListAlarmRequest listAlarm = new ListAlarmRequest();
        listAlarm.setRegionId("cn-beijing");
        listAlarm.setNamespace("acs_ecs_dashboard");
        listAlarm.setDimension(JSON.toJSONString(dimension));
        listAlarm.setIsEnable(true);
        listAlarm.setPageNumber(pageNumber);
        listAlarm.setPageSize(pageSize);
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
        createNotifyPolicy.setEndTime(System.currentTimeMillis() + n * 60 * 1000 * 60);
        createNotifyPolicy.setPolicyType("PauseNotify");
        createNotifyPolicy.setGroupId(groupId);
        return client.getAcsResponse(createNotifyPolicy);
    }

    /**
     *
     * @param groupId
     * @param alarm
     * @param resource
     * @param client
     * @return
     * @throws ClientException
     */
    public static ListNotifyPolicyResponse listNotifyPolicy(String groupId,ListAlarmResponse.Alarm alarm,ListMyGroupInstancesDetailsResponse.Resource resource,IAcsClient client) throws ClientException {
        JSONObject dimensions = new JSONObject();
        dimensions.put("instanceId", resource.getInstanceId());
        ListNotifyPolicyRequest listNotifyPolicy = new ListNotifyPolicyRequest();
        listNotifyPolicy.setRegionId("cn-beijing");
        listNotifyPolicy.setDimensions(JSON.toJSONString(dimensions));
        listNotifyPolicy.setPolicyType("PauseNotify");
        listNotifyPolicy.setAlertName(alarm.getName());
        listNotifyPolicy.setGroupId(groupId);
        return client.getAcsResponse(listNotifyPolicy);
    }

    /**
     * 删除实例下的所有暂停报警规则
     * @param client
     * @return
     * @throws ClientException
     */
    public static boolean deleteNotifyPolicy(ListNotifyPolicyResponse.NotifyPolicy notifyPolicy,IAcsClient client) throws ClientException {
        DeleteNotifyPolicyRequest deleteNotifyPolicy = new DeleteNotifyPolicyRequest();
        deleteNotifyPolicy.setPolicyType(notifyPolicy.getType());
        deleteNotifyPolicy.setDimensions(notifyPolicy.getDimensions());
        deleteNotifyPolicy.setAlertName(notifyPolicy.getAlertName());
        deleteNotifyPolicy.setId(notifyPolicy.getId());
        deleteNotifyPolicy.setGroupId(notifyPolicy.getGroupId());
        DeleteNotifyPolicyResponse response = client.getAcsResponse(deleteNotifyPolicy);
        if(Boolean.TRUE.toString().equals(response.getSuccess())) {
            return true;
        }else{
            return false;
        }
    }
}
