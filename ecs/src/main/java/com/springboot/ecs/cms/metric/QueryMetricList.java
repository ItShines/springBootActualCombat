package com.springboot.ecs.cms.metric;

import com.alibaba.cms.cms.ProfileStatic;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.QueryMetricListRequest;
import com.aliyuncs.cms.model.v20180308.QueryMetricListResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 查询监控数据列表 -- QueryMetricList
 * @author wb-ryd460712
 */
public class QueryMetricList {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile(ProfileStatic.regionId, ProfileStatic.accessKeyId, ProfileStatic.secret);
        IAcsClient client = new DefaultAcsClient(profile);

        QueryMetricListRequest queryMetricList = new QueryMetricListRequest();
        //RegionId String 非必选 地域Id
        queryMetricList.setRegionId("cn-beijing");
        //Metric String 必选必填 监控名称  DiskReadBPS
        queryMetricList.setMetric("CPUUtilization");
        //Period String 非必选 时间间隔，统一用秒数来计算，例如60,300,900。
        //如果不填写，则按照注册监控项时申明的上报周期来查询原始数据。如果填写统计周期,则查询对应的统计数据。
        queryMetricList.setPeriod("60");
        //StartTime String 非必选 开始时间 可以传入距离1970年1月1日0点的毫秒数，也可以传入format数据，如2015-10-20 00:00:00。
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l = System.currentTimeMillis() - 30 * 60 * 1000;
        String s = String.valueOf(l / 1000) + "000";
        Date date = new Date(Long.valueOf(s));
        String startTime = simpleDateFormat.format(date);
        queryMetricList.setStartTime(String.valueOf(l));
        queryMetricList.setStartTime(startTime);
        //EndTime String 非必须 结束时间，可以传入距离1970年1月1日0点的毫秒数，也可以传入format数据，如2015-10-20 00:00:00。
        String endTime = simpleDateFormat.format(new Date());
        queryMetricList.setEndTime(String.valueOf(System.currentTimeMillis()));
        queryMetricList.setEndTime(endTime);
        //Dimensions String 非必选 用于过滤监控数据的key-value集合，key可以使用注册监控项时申明的dimensionKeys中的一个或多个，
        // value为该key对应的值。instanceId是必填项需要使用JSON字符串表示该Map对象，传入时请使用字符串，dimension要求必须按顺序传入。
        JSONObject dimension = new JSONObject();
        dimension.put("instanceId", "i-2zehwry4r1spt5s6abrb");
        queryMetricList.setDimensions(JSON.toJSONString(dimension));
        //Cursor String 非必选 游标 TODO understand
        queryMetricList.setCursor(null);
        //Page String 非必选 页码
        //Length String 非必选 返回监控数据的每页大小，用于分页查询。默认值为1000，即每页1000条监控数据
        queryMetricList.setLength("1000");
        //Express String 非必选 扩展参数
        queryMetricList.setExpress("");
        //Project String 必选必填 监控数据所属产品，如 “acs_ecs_dashboard”，“acs_rds_dashboard”等
        queryMetricList.setProject("acs_ecs_dashboard");
        try {
            QueryMetricListResponse response = client.getAcsResponse(queryMetricList);
            System.out.println("ErrorCode:" + response.getCode());
            System.out.println("Period:" + response.getPeriod());
            System.out.println("Cursor:" + response.getCursor());
            System.out.println("ErrorMessage:" + response.getMessage());
            System.out.println("RequestId:" + response.getRequestId());
            System.out.println("Datapoints:" + response.getDatapoints());
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
