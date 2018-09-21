package com.springboot.ecs.cms.groups.api;


import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.GetMyGroupsRequest;
import com.aliyuncs.cms.model.v20180308.GetMyGroupsResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 查询应用分组-GetMyGroups 问题记录
 * 1.描述
 *      查询一个应用分组, 如果符合条件的分组将分会发生异常，并且错误码为404，如果希望返回空可以调用ListMyGroups API
 *      描述冗余，导致内容错乱
 * 2.请求参数
 *      无具体请求参数描述，采用参考OpenAPI Explorer浏览器形式,但浏览器形式的参数的字段无数据类型，由于浏览器提供的API的Java示例代码与
 *          我们CMS Open API提供的Java SDK的请求实例调用方式不一致。
 *
 * 3.返回参数
 *      Group  应用分组列表  缺少字段类型、且Group集合里无字段的具体描述
 * 4.错误码
 *      错误码信息不全，例如少成功、失败(服务器异常)，虽在返回参数里有写，但是否应该更明确
 * @author wb-ryd460712
 */
public class GetMyGroups {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);
        //设置参数
        GetMyGroupsRequest getMyGroups = new GetMyGroupsRequest();
        //RegionId String 查询地域 非必传
        getMyGroups.setRegionId("cn-beijing");
        //GroupId Long 分组的ID
        getMyGroups.setGroupId(1301506L);
        //Type String 分组的类型，有些分组是从其他系统同步而来，非必传
        // custom[为默认值，表示用户自己通过云监控控制台UI创建的],
        // aone_group[表示这些分组从Aone同步而来],
        // ehpc_cluster[表示这些分组从EHPC集群同步而来].
        getMyGroups.setType("custom");
        //SelectContactGroups Boolean 用于标识是否返回分组的联系人组信息 值为 true/false, 默认false, 非必传
        getMyGroups.setSelectContactGroups(false);
        //InstanceId String 根据分组下的关联实例id查询，主要用于查询实例是否归属当前分组 非必传
        getMyGroups.setInstanceId("i-2zehwry4r1spt5s6abrb");
        //BindUrl String 跟其他系统的分组绑定, 用于实现与其他分组的同步，推荐使用URL的格式，产品名称://集群ID/角色名称, 例如 ehpc://i-dadfasdf/Login
        getMyGroups.setBindUrl("");
        //GroupName String 应用分组名称 不支持模糊检索，非必传
        getMyGroups.setGroupName("");

        // 发起请求
        try {
            GetMyGroupsResponse response = client.getAcsResponse(getMyGroups);
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
