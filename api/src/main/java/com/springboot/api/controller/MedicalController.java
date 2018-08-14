package com.springboot.api.controller;

import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.model.SickVisitInfoModel;
import com.springboot.api.service.MedicalService;
import com.springboot.api.util.BaseResponseModel;
import com.springboot.api.util.GsonUtil;
import com.springboot.api.util.RequestVelueUtil;
import com.springboot.api.util.ResponseCodeConstant;
import com.springboot.api.vo.SickVisitInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 门诊医保报销
 * @author Future
 */
@RestController
public class MedicalController {

    @Autowired
    private ResponseCodeConstant responseCodeConstant;
    @Autowired
    private MedicalService medicalService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 测试接口
     * @return
     */
    @RequestMapping(value = "test")
    public @ResponseBody Object test() {
        BaseResponseModel baseResponseModel = new BaseResponseModel();
        baseResponseModel.setCode(responseCodeConstant.success);
        baseResponseModel.setMessage("测试访问成功，可以正常使用！！！");
        baseResponseModel.setResponseTime(new Date());
        return baseResponseModel;
    }

    /**
     * 医保住院-查询是否医保中心登记
     * @param request
     * @return
     */
    @RequestMapping("/findSickVisitInfo")
    public @ResponseBody Object findSickVisitInfo(HttpServletRequest request){
        logger.info("findSickVisitInfo() is start");
        BaseResponseModel baseResponseModel = new BaseResponseModel();
        try{
            String requestStr = RequestVelueUtil.parseRequestValue(request);
            SickVisitInfoVo sickVisitInfoVo = GsonUtil.strToObj(requestStr, SickVisitInfoVo.class);
            SickVisitInfo sickVisitInfo = medicalService.findSickVisitInfo(sickVisitInfoVo);
            SickVisitInfoModel visitInfoModel = new SickVisitInfoModel();
            visitInfoModel.setData(sickVisitInfo);
            baseResponseModel.setBody(visitInfoModel);
            baseResponseModel.setCode(responseCodeConstant.success);
            baseResponseModel.setMessage("查询成功！");
        }catch (Exception e) {
            baseResponseModel.setCode(responseCodeConstant.error);
            baseResponseModel.setMessage("服务器异常！");
            e.printStackTrace();
        }finally{
            logger.info("findSickVisitInfo() is end");
        }
        return baseResponseModel;
    }

}
