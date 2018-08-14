package com.springboot.api.test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springboot.api.util.Base64SecurityUtil;
import com.springboot.api.util.BaseResponseModel;
import com.springboot.api.util.RequestUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedicalControllerTest {
    @Test
    public void findSickVisitInfo() {
        JsonObject json = new JsonObject();
        Gson gson = new Gson();
        json.addProperty("residenceNo", "1");
        gson.toJson(json);
        System.out.println(json.toString());
//        String str = RequestUtil.httpPostJsonBody("findSickVisitInfo",Base64SecurityUtil.getEncryptString(json.toString()));
        String str = RequestUtil.httpPostJsonBody("findSickVisitInfo",json.toString());
        BaseResponseModel model = gson.fromJson(str, BaseResponseModel.class);
        assertEquals(model.getCode(), "200");
    }
}
