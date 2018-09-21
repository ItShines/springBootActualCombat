package com.springboot.ecs.cms.groups.browser;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author wb-ryd460712
 */
public class ListMyGroups {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAIkLRbDKfBdkip", "R0iz8XbwIKSUn2Vb2rhaWXfL4HejEo");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("metrics.aliyuncs.com");
        request.setVersion("2018-03-08");
        request.setAction("ListMyGroups");
        //RegionId 查询地域 非必传
        request.putQueryParameter("RegionId", "cn-beijing");
        //Keyword GroupName的关键字，支持模糊检索,非必传
        request.putQueryParameter("Keyword", "");
        //用于标识是否返回分组的联系人组信息 值为 true/false, 默认false, 非必传
        request.putQueryParameter("SelectContactGroups", "false");
        //分页页码, 非必传 默认从一开始
        request.putQueryParameter("PageNumber", "1");
        //每页返回的记录数,  非必传 默认30
        request.putQueryParameter("PageSize", "30");
        //分组的类型，有些分组是从其他系统同步而来，非必传
        // custom[为默认值，表示用户自己通过云监控控制台UI创建的],
        // aone_group[表示这些分组从Aone同步而来],
        // ehpc_cluster[表示这些分组从EHPC集群同步而来].
        request.putQueryParameter("Type", "custom");
        //根据分组下的关联实例id查询，主要用于查询实例是否归属当前分组 非必传
        request.putQueryParameter("InstanceId", "i-2zehwry4r1spt5s6abrb");
        //跟其他系统的分组绑定, 用于实现与其他分组的同步， 非必传
        // 推荐使用URL的格式，产品名称://集群ID/角色名称, 例如 ehpc://i-dadfasdf/Login
        request.putQueryParameter("BindUrls", "");
        //应用分组名称 不支持模糊检索，非必传
        request.putQueryParameter("GroupName", "");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
