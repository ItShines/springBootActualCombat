package com.springboot.ecs.cms.groups.api;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.ListMyGroupInstancesDetailsRequest;
import com.aliyuncs.cms.model.v20180308.ListMyGroupInstancesDetailsResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 列出指定分组下的详细实例信息-ListMyGroupInstancesDetails
 * @author wb-ryd460712
 */
public class ListMyGroupInstancesDetails {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        //参数设置
        ListMyGroupInstancesDetailsRequest myGroupInstancesDetails = new ListMyGroupInstancesDetailsRequest();
        //RegionId String 非必选 区域
        myGroupInstancesDetails.setRegionId("cn-beijing");
        //PageSize Integer 非必选 每页返回的记录数, 默认30
        myGroupInstancesDetails.setPageSize(30);
        //GroupId Long 必选 分组Id
        myGroupInstancesDetails.setGroupId(1301506L);
        //PageNumber Integer 非必选 分页页码，默认从1开始
        myGroupInstancesDetails.setPageNumber(1);
        //Category String 非必选 只返回指定类型的实例,
        // category可选值: ECS(ECS服务器), RDS(RDS数据库), SLB(SLB负载均衡), KVSTORE(Redis缓存), MONGODB(MongoDB 数据库),
        // CDN(CDN域名,CDN无regionId，不需要填), EIP(EIP 弹性公网IP), MEMCACHE(新版Memcache)
        myGroupInstancesDetails.setCategory(null);
        //Keyword String 非必选 实例名称的关键字,支持模糊检索
        myGroupInstancesDetails.setKeyword("zhangsanfeng");
        //InstanceIds String 非必选 实例列表 实例详情中的实例Id 可为空
        myGroupInstancesDetails.setInstanceIds("i-2zehwry4r1spt5s6abrb");

        // 发起请求
        try {
            ListMyGroupInstancesDetailsResponse response = client.getAcsResponse(myGroupInstancesDetails);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getErrorCode());
            System.out.println("ErrorMessage:" + response.getErrorMessage());
            System.out.println("RequestId:" + response.getRequestId());
            System.out.println("PageNumber:" + response.getPageNumber());
            System.out.println("PageSize:" + response.getPageSize());
            System.out.println("Resources:" + JSON.toJSONString(response.getResources()));
            System.out.println("Total:" + response.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
