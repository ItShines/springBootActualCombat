package com.springboot.ecs.cms.groups.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.AddMyGroupInstancesRequest;
import com.aliyuncs.cms.model.v20180308.AddMyGroupInstancesResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author wb-ryd460712
 */
public class AddMyGroupInstances {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        //设置参数
        AddMyGroupInstancesRequest myGroupInstances = new AddMyGroupInstancesRequest();
        //RegionId String 非必选 区域
        myGroupInstances.setRegionId("cn-beijing");
        //GroupId Long 必选 分组Id
        myGroupInstances.setGroupId(1312513L);

        JSONObject instance1 = new JSONObject();
        instance1.put("instanceId","i-2zehwry4r1spt5s6abrb");
        instance1.put("category","ECS");
        instance1.put("regionId","cn-beijing");
        JSONObject instance2 = new JSONObject();
        instance2.put("instanceId","i-2zehwry4r1spt5s6abrb");
        instance2.put("category","RDS");
        instance2.put("regionId","cn-beijing");
        JSONObject instance3 = new JSONObject();
        instance3.put("instanceId","i-2zehwry4r1spt5s6abrb");
        instance3.put("category","SLB");
        instance3.put("regionId","cn-beijing");
        JSONArray array = new JSONArray();
        array.add(instance1);
        array.add(instance2);
        array.add(instance3);
        //Instances String 非必选
        // 实例列表Json格式列表例如:[{ "instanceId": "i-uf6gmt1v7v6ecjhy1sr1", "category": "ECS", "regionId": "cn-shanghai" }].
        // category可选值: ECS(ECS服务器), RDS(RDS数据库), SLB(SLB负载均衡), KVSTORE(Redis缓存), MONGODB(MongoDB 数据库),
        // CDN(CDN域名,CDN无regionId，不需要填), EIP(EIP 弹性公网IP), MEMCACHE(新版Memcache)
        myGroupInstances.setInstances(JSON.toJSONString(array));

        // 发起请求
        try {
            AddMyGroupInstancesResponse response = client.getAcsResponse(myGroupInstances);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getErrorCode());
            System.out.println("ErrorMessage:" + response.getErrorMessage());
            System.out.println("RequestId:" + response.getRequestId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
