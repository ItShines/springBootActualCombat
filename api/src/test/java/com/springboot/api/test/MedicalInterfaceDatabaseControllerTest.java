package com.springboot.api.test;

import com.google.gson.Gson;
import com.springboot.api.util.BaseResponseModel;
import com.springboot.api.util.RequestUtil;
import com.springboot.api.vo.Kc27Vo;
import com.springboot.api.vo.Kc28Vo;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MedicalInterfaceDatabaseControllerTest {

    @Test
    public void saveKc28() {
        Gson gson = new Gson();
        List<Kc28Vo> kc28VoList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Kc28Vo kc28Vo = new Kc28Vo();
            kc28Vo.setAKB020("1" + i);
            kc28Vo.setAKC220("CF"+i);
            kc28Vo.setCKC158(i);
            kc28Vo.setAAE011("1");
            kc28Vo.setAAE036(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            kc28Vo.setAKA063("A");
            kc28Vo.setAKC222("HISXXX"+i);
            kc28Vo.setAKC223("HISXXX"+i);
            kc28Vo.setAKC227((1.0+i));
            kc28Vo.setCKC197(1.0+i);
            kc28Vo.setCKC198(1.0);
            kc28Vo.setCKC159("xxx"+i);
            kc28Vo.setCKC160("xxx"+i);
            kc28Vo.setCKC161("xxx"+i);
            kc28Vo.setCKC169("xxx"+i);
            kc28Vo.setCKC170("xxx"+i);
            kc28Vo.setCKC171("xxx"+i);
            kc28Vo.setCKE081("2");
            kc28Vo.setCKE085("1");
            kc28Vo.setCKE086("1");
            kc28Vo.setCKE089(1);
            kc28Vo.setCKE090("1");
            kc28Vo.setAAC002("2222"+i);
            kc28Vo.setSKA003("000");
            kc28VoList.add(kc28Vo);
        }
        String json = gson.toJson(kc28VoList);
        System.out.println(json);
//        String str = RequestUtil.httpPostJsonBody("interfaceDatabase/saveKc28",json.toString());
//        BaseResponseModel model = gson.fromJson(str, BaseResponseModel.class);
//        assertEquals(model.getCode(), "200");
    }

    @Test
    public void saveKc27() {
        Gson gson = new Gson();
        List<Kc27Vo> kc27VoList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Kc27Vo kc27Vo = new Kc27Vo();
            kc27Vo.setAKB020("1" + i);
            kc27Vo.setCKC179("2222"+i);
            kc27Vo.setAKC190(" ");
            kc27Vo.setAKC220("CF"+i);
            kc27Vo.setCKC158(i);
            kc27Vo.setAAE011("1");
            kc27Vo.setAAE036(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            kc27Vo.setAKA063("123");
            kc27Vo.setAKC222("HISXXX"+i);
            kc27Vo.setAKC223("HISXXX"+i);
            kc27Vo.setAKC227((1.222222222+i));
            kc27Vo.setCKC197(1.0 + i*0.00001+i);
            kc27Vo.setCKC198(1 + i*0.00001);
            kc27Vo.setCKC159(""+(1.0 + i*0.00001 +i));
            kc27Vo.setCKC160("xx"+i);
            kc27Vo.setCKC161(""+(1.0 + i*0.00001));
            kc27Vo.setCKC169("xxx"+i);
            kc27Vo.setCKC170("xxx"+i);
            kc27Vo.setCKC171("xxx"+i);
            kc27Vo.setCKE081("1");
            kc27Vo.setCKE085("2");
            kc27Vo.setCKE086("2");
            kc27Vo.setCKE089(1.0);
            kc27Vo.setCKE090("在院用药");
            kc27Vo.setSKA003("000");
            kc27Vo.setCKC188("0");
            kc27VoList.add(kc27Vo);
        }
        String json = gson.toJson(kc27VoList);
        System.out.println(json);
        String str = RequestUtil.httpPostJsonBody("interfaceDatabase/saveKc27",json.toString());
        BaseResponseModel model = gson.fromJson(str, BaseResponseModel.class);
        assertEquals(model.getCode(), "200");
    }

}
