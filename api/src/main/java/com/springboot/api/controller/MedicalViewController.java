package com.springboot.api.controller;

import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.entity.ViewCode;
import com.springboot.api.model.SickVisitInfoModel;
import com.springboot.api.model.ViewCodeModel;
import com.springboot.api.service.MedicalViewService;
import com.springboot.api.util.BaseResponseModel;
import com.springboot.api.util.FinalCodeConstant;
import com.springboot.api.util.GsonUtil;
import com.springboot.api.util.RequestValueUtil;
import com.springboot.api.vo.SickVisitInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 医保视图
 *
 * @author Future
 */
@RestController
@RequestMapping("/view/")
public class MedicalViewController {

    @Autowired
    private FinalCodeConstant finalCodeConstant;

    @Autowired
    private MedicalViewService medicalViewService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 测试接口
     *
     * @return
     */
    @RequestMapping(value = "test")
    public @ResponseBody
    Object test() {
        BaseResponseModel baseResponseModel = new BaseResponseModel();
        baseResponseModel.setCode(finalCodeConstant.success);
        baseResponseModel.setMessage("测试访问成功，可以正常使用！！！");
        baseResponseModel.setResponseTime(new Date());
        return baseResponseModel;
    }

    @RequestMapping(value = "/selectViewCode")
    public @ResponseBody Object selectViewCode() {
        logger.info("selectViewCode() is start!");
        BaseResponseModel responseModel = new BaseResponseModel();
        try {
            List<ViewCode> viewCodes = medicalViewService.selectViewCode();
            ViewCodeModel viewCodeModel = new ViewCodeModel();
            viewCodeModel.setData(viewCodes);
            responseModel.setBody(viewCodeModel);
            responseModel.setCode(finalCodeConstant.success);
            responseModel.setMessage("查询成功！");
            responseModel.setResponseTime(new Date());
        } catch (Exception e){
            e.printStackTrace();
            String tmp = e.getMessage();
            responseModel.setCode(finalCodeConstant.error);
            responseModel.setMessage("服务器异常！异常信息为: " + tmp.substring(tmp.indexOf("ORA-"), tmp.indexOf("The") - 7));
        }finally {
            logger.info("findSickVisitInfo() is end");
        }
        return responseModel;
    }


    /**
     * 医保住院-查询是否医保中心登记
     *
     * @param request
     * @return
     */
    @RequestMapping("/findSickVisitInfo")
    public @ResponseBody
    Object findSickVisitInfo(HttpServletRequest request) {
        logger.info("findSickVisitInfo() is start");
        BaseResponseModel baseResponseModel = new BaseResponseModel();
        try {
            String requestStr = RequestValueUtil.parseRequestValue(request);
            SickVisitInfoVo sickVisitInfoVo = GsonUtil.strToObj(requestStr, SickVisitInfoVo.class);
            if (sickVisitInfoVo == null || StringUtils.isBlank(sickVisitInfoVo.getResidenceNo())) {
                baseResponseModel.setCode(finalCodeConstant.clinic_param_null);
                baseResponseModel.setMessage("客户端参数为null！");
                return baseResponseModel;
            }
            sickVisitInfoVo.setHospitalNumber(finalCodeConstant.hospital_number);
            SickVisitInfo sickVisitInfo = medicalViewService.findSickVisitInfo(sickVisitInfoVo);
            SickVisitInfoModel visitInfoModel = new SickVisitInfoModel();
            visitInfoModel.setData(sickVisitInfo);
            baseResponseModel.setBody(visitInfoModel);
            baseResponseModel.setCode(finalCodeConstant.success);
            baseResponseModel.setMessage("查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            String tmp = e.getMessage();
            baseResponseModel.setCode(finalCodeConstant.error);
            baseResponseModel.setMessage("服务器异常！异常信息为: " + tmp.substring(tmp.indexOf("ORA-"), tmp.indexOf("The") - 7));
            e.printStackTrace();
        } finally {
            logger.info("findSickVisitInfo() is end");
        }
        return baseResponseModel;
    }


}
