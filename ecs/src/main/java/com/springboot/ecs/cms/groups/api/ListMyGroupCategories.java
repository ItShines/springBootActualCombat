package com.springboot.ecs.cms.groups.api;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cms.model.v20180308.ListMyGroupCategoriesRequest;
import com.aliyuncs.cms.model.v20180308.ListMyGroupCategoriesResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 列出指定分组下的产品分类-ListMyGroupCategories 问题记录
 * 1.请求参数
 *
 * 2.返回参数
 *  Category Array 实例资源类型信息列表 无具体对象描述
 *
 * @author wb-ryd460712
 */
public class ListMyGroupCategories {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing","LTAIkLRbDKfBdkip","R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        //设置参数
        ListMyGroupCategoriesRequest myGroupCategories = new ListMyGroupCategoriesRequest();
        //RegionId String 非必选 区域
        myGroupCategories.setRegionId("cn-beijing");
        //GroupId Long 必选 分组的ID
        myGroupCategories.setGroupId(1301506L);

        //发送请求
        try {
            ListMyGroupCategoriesResponse response = client.getAcsResponse(myGroupCategories);
            System.out.println("Success:" + response.getSuccess());
            System.out.println("ErrorCode:" + response.getErrorCode());
            System.out.println("ErrorMessage:" + response.getErrorMessage());
            System.out.println("RequestId:" + response.getRequestId());
            System.out.println("Category:" + JSON.toJSONString(response.getCategory()));
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
