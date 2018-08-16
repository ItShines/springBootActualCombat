package com.springboot.api.test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springboot.api.util.BaseResponseModel;
import com.springboot.api.util.RequestUtil;
import com.springboot.api.vo.Kc28Vo;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MedicalInterfaceDatabaseControllerTest {

    @Test
    public void selectMedReceiptRecordMasterTest() {
        Gson gson = new Gson();
        List<Kc28Vo> kc28VoList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Kc28Vo kc28Vo = new Kc28Vo();
            kc28Vo.setAKB020("1" + i);
            kc28Vo.setAKC220("CF"+i);
            kc28Vo.setCKC158(1000+i);
            kc28Vo.setAAE011("1");
            kc28Vo.setAAE036(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            kc28Vo.setAKA063(""+i);
            kc28Vo.setAKC222("HISXXX"+i);
            kc28Vo.setAKC223("HISXXX"+i);
            kc28Vo.setAKC227((1.0+i) * (1.0+i));
            kc28Vo.setCKC197(1.0+i);
            kc28Vo.setCKC198(1.0+i);
            kc28Vo.setCKC159("xxx"+i);
            kc28Vo.setCKC160("xxx"+i);
            kc28Vo.setCKC161("xxx"+i);
            kc28Vo.setCKC169("xxx"+i);
            kc28Vo.setCKC170("xxx"+i);
            kc28Vo.setCKC171("xxx"+i);
            kc28Vo.setCKE081(""+ (i-1));
            kc28Vo.setCKE085(""+ (i-1));
            kc28Vo.setCKE086(""+ (i-1));
            kc28Vo.setCKE089(1);
            kc28Vo.setCKE090("1");
            kc28Vo.setAAC002("2222"+i);
            kc28Vo.setSKA003("000");
            kc28VoList.add(kc28Vo);
        }
        String json = gson.toJson(kc28VoList);
        System.out.println(json);
        String str = RequestUtil.httpPostJsonBody("interfaceDatabase/saveKc28",json.toString());
        BaseResponseModel model = gson.fromJson(str, BaseResponseModel.class);
        assertEquals(model.getCode(), "200");
    }

}
