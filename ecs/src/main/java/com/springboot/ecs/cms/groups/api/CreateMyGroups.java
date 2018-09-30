package com.springboot.ecs.cms.groups.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.CreateMyGroupsRequest;
import com.aliyuncs.cms.model.v20180308.CreateMyGroupsResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author wb-ryd460712
 */
public class CreateMyGroups {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        //设置参数
        CreateMyGroupsRequest createMyGroups = new CreateMyGroupsRequest();
        //RegionId String 非必选 区域
        createMyGroups.setRegionId("cn-beijing");
        //Type String 非必选 分组的类型，有些分组是从其他系统同步而来，
        // custom[为默认值，表示用户自己通过云监控控制台UI创建的],aone_group[表示这些分组从Aone同步而来], ehpc_cluster[表示这些分组从EHPC集群同步而来].
        createMyGroups.setType("custom");
        //GroupName String 非必选 分组名称
        createMyGroups.setGroupName("SDK测试");
        //ServiceId Long 非必选 归属的服务ID ?
        createMyGroups.setServiceId(286668037510407934L);
        //BindUrl String 非必选 跟其他系统的分组绑定, 用于实现与其他分组的同步，推荐使用URL的格式，产品名称://集群ID/角色名称, 例如 ehpc://i-dadfasdf/Login
        createMyGroups.setBindUrl("acs:ram::1087477042505994:role/cms");
        //ContactGroups String 非必选 报警联系人分组列表, 多个用英文逗号分隔, 例如: dev,ops
        createMyGroups.setContactGroups("紧急联络人");
        JSONObject options = new JSONObject();
        //模板Id  default默认
        options.put("alarmTemplate", "124191");
        //报警通知级别
        options.put("alarmNotifyLevel", "2");
        //是否安装监控agent
        options.put("installAgent", "false");
        //Options String 非必选 报警规则模板和资源类型配置信息
        createMyGroups.setOptions(JSON.toJSONString(options));
        // 发起请求
        try {
            CreateMyGroupsResponse response = client.getAcsResponse(createMyGroups);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getErrorCode());
            System.out.println("ErrorMessage:" + response.getErrorMessage());
            System.out.println("RequestId:" + response.getRequestId());
            System.out.println("GroupId:" + response.getGroupId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
