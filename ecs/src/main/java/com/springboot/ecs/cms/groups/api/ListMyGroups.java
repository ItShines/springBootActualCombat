package com.springboot.ecs.cms.groups.api;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.ListMyGroupsRequest;
import com.aliyuncs.cms.model.v20180308.ListMyGroupsResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 问题记录
 * 1.请求参数
 *      无具体请求参数描述，采用参考OpenAPI Explorer浏览器形式,但浏览器形式的参数的字段无数据类型，由于浏览器提供的API的Java示例代码与
 *          我们CMS Open API提供的Java SDK的请求实例调用方式不一致。
 * 2.返回参数
 *      Resources List 应用分组列表 list结果集里的字段无描述
 * 3.错误码
 *      错误码信息不全，例如少成功、失败(服务器异常)，虽在返回参数里有写，但是否应该更明确
 * @author wb-ryd460712
 */
public class ListMyGroups {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        //设置参数
        ListMyGroupsRequest listMyGroups = new ListMyGroupsRequest();
        //RegionId 查询地域 非必传
        listMyGroups.setRegionId("cn-beijing");
        //Keyword GroupName的关键字，支持模糊检索,非必传
        listMyGroups.setKeyword("");
        //SelectContactGroups 用于标识是否返回分组的联系人组信息 值为 true/false, 默认false, 非必传
        listMyGroups.setSelectContactGroups(false);
        //PageNumber 分页页码, 非必传 默认从一开始
        listMyGroups.setPageNumber(1);
        //PageSize 每页返回的记录数,  非必传 默认30
        listMyGroups.setPageSize(30);
        //Type 分组的类型，有些分组是从其他系统同步而来，非必传
        // custom[为默认值，表示用户自己通过云监控控制台UI创建的],
        // aone_group[表示这些分组从Aone同步而来],
        // ehpc_cluster[表示这些分组从EHPC集群同步而来].
        listMyGroups.setType("custom");
        //InstanceId 根据分组下的关联实例id查询，主要用于查询实例是否归属当前分组 非必传
        listMyGroups.setInstanceId("i-2zehwry4r1spt5s6abrb");
        //BindUrls 跟其他系统的分组绑定, 用于实现与其他分组的同步， 非必传
        // 推荐使用URL的格式，产品名称://集群ID/角色名称, 例如 ehpc://i-dadfasdf/Login
        listMyGroups.setBindUrls("");
        //GroupName 应用分组名称 不支持模糊检索，非必传
        listMyGroups.setGroupName("");

        // 发起请求
        try {
            ListMyGroupsResponse response = client.getAcsResponse(listMyGroups);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getErrorCode());
            System.out.println("ErrorMessage:" + response.getErrorMessage());
            System.out.println("RequestId:" + response.getRequestId());
            System.out.println("PageNumber:" + response.getPageNumber());
            System.out.println("PageSize:" + response.getPageSize());
            System.out.println("Total:" + response.getTotal());
            System.out.println("Resources:" + JSON.toJSONString(response.getResources()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
