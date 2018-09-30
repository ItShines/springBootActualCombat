package com.springboot.ecs.cms.groups.api;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.UpdateMyGroupsRequest;
import com.aliyuncs.cms.model.v20180308.UpdateMyGroupsResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 修改应用分组-UpdateMyGroups 问题记录
 * 1.描述
 *      根据ID修改应用分组, 为空的字段将不会被修改
 *      描述指定不清晰
 * 2.请求参数
 *      已有参数描述不清晰；
 *      且部分参数缺失，缺失的采用参考OpenAPI Explorer浏览器形式,但浏览器形式的参数的字段无数据类型，由于浏览器提供的API的Java示例代码与
 *          我们CMS Open API提供的Java SDK的请求实例调用方式不一致。
 *
 * 3.返回参数
 *      Group  应用分组列表  缺少字段类型、且Group集合里无字段的具体描述
 * 4.错误码
 *      错误码信息不全，例如少成功、失败(服务器异常)，虽在返回参数里有写，但是否应该更明确
 *      操作失败并未返回错误码，直接抛出异常
 *      com.aliyuncs.exceptions.ClientException: AccessForbidden : User not authorized to operate on the specified resource.
 * @author wb-ryd460712
 */
public class UpdateMyGroups {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        //设置参数
        UpdateMyGroupsRequest updateMyGroupsRequest = new UpdateMyGroupsRequest();
        //RegionId String 查询地域 非必传
        updateMyGroupsRequest.setRegionId("cn-beijing");
        //BindUrls String 跟其他系统的分组绑定, 用于实现与其他分组的同步，推荐使用URL的格式，产品名称://集群ID/角色名称, 例如 ehpc://i-dadfasdf/Login
        updateMyGroupsRequest.setBindUrls("");
        //GroupId String 分组的ID 必传
        updateMyGroupsRequest.setGroupId("1301506");
        //GroupName String 应用分组名称 非必传
        updateMyGroupsRequest.setGroupName("一个ECS");
        //Type String 分组的类型，有些分组是从其他系统同步而来，非必传
        // custom[为默认值，表示用户自己通过云监控控制台UI创建的],
        // aone_group[表示这些分组从Aone同步而来],
        // ehpc_cluster[表示这些分组从EHPC集群同步而来].
        updateMyGroupsRequest.setType("custom");
        //ContactGroups 报警联系人分组列表, 多个用英文逗号分隔, 例如: dev,ops
        updateMyGroupsRequest.setContactGroups("");

        // 发起请求
        try {
            System.out.println("updateMyGroupsRequest:" + JSON.toJSONString(updateMyGroupsRequest));
            UpdateMyGroupsResponse response = client.getAcsResponse(updateMyGroupsRequest);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getErrorCode());
            System.out.println("ErrorMessage:" + response.getErrorMessage());
            System.out.println("RequestId:" + response.getRequestId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
