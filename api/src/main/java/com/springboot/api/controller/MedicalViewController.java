package com.springboot.api.controller;

import com.springboot.api.entity.MedReceiptRecordMaster;
import com.springboot.api.entity.ParaCaptureItem;
import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.entity.ViewCode;
import com.springboot.api.model.MedReceiptRecordMasterModel;
import com.springboot.api.model.ParaCaptureItemModel;
import com.springboot.api.model.SickVisitInfoModel;
import com.springboot.api.model.ViewCodeModel;
import com.springboot.api.service.MedicalViewService;
import com.springboot.api.util.*;
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
@RequestMapping("/view")
public class MedicalViewController {

    @Autowired
    private ResponseCodeConstant responseCodeConstant;

    @Autowired
    private MedicalViewService medicalViewService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 测试接口
     * @return
     */
    @RequestMapping(value = "/test")
    public @ResponseBody Object test() {
        BaseResponseModel baseResponseModel = new BaseResponseModel();
        baseResponseModel.setCode(responseCodeConstant.success);
        baseResponseModel.setMessage("测试访问成功，可以正常使用！！！");
        baseResponseModel.setResponseTime(new Date());
        return baseResponseModel;
    }

    /**
     * 查询项目名称与代码的对应关系
     * @return
     */
    @RequestMapping(value = "/selectViewCode")
    public @ResponseBody Object selectViewCode() {
        logger.info("selectViewCode() is start!");
        BaseResponseModel responseModel = new BaseResponseModel();
        try {
            List<ViewCode> viewCodes = medicalViewService.selectViewCode();
            ViewCodeModel viewCodeModel = new ViewCodeModel();
            viewCodeModel.setData(viewCodes);
            responseModel.setBody(viewCodeModel);
            responseModel.setCode(responseCodeConstant.success);
            responseModel.setMessage("查询成功！");
            responseModel.setResponseTime(new Date());
        } catch (Exception e){
            String tmp = e.getMessage();
            e.printStackTrace();
            responseModel.setCode(responseCodeConstant.error);
            responseModel.setMessage("服务器异常！异常信息为: " + tmp.substring(tmp.indexOf("ORA-"), tmp.indexOf("The") - 7));
            logger.info("服务器异常！异常信息为: " + tmp);
        }finally {
            logger.info("selectViewCode() is end");
        }
        return responseModel;
    }

    /**
     * 医保收费项目目录视图
     * @return
     */
    @RequestMapping(value = "/selectParaCaptureItem")
    public @ResponseBody Object selectParaCaptureItem() {
        logger.info("selectParaCaptureItem() is start!");
        BaseResponseModel responseModel = new BaseResponseModel();
        try {
            List<ParaCaptureItem> paraCaptureItems = medicalViewService.selectParaCaptureItem();
            ParaCaptureItemModel paraCaptureItemModel = new ParaCaptureItemModel();
            paraCaptureItemModel.setData(paraCaptureItems);
            responseModel.setBody(paraCaptureItemModel);
            responseModel.setCode(responseCodeConstant.success);
            responseModel.setMessage("查询成功！");
            responseModel.setResponseTime(new Date());
        } catch (Exception e){
            e.printStackTrace();
            String tmp = e.getMessage();
            responseModel.setCode(responseCodeConstant.error);
            responseModel.setMessage("服务器异常！异常信息为: " + tmp.substring(tmp.indexOf("ORA-"), tmp.indexOf("The") - 7));
            logger.info("服务器异常！异常信息为: " + tmp);
        }finally {
            logger.info("selectParaCaptureItem() is end");
        }
        return responseModel;
    }

    /**
     * 医保住院-查询是否医保中心登记
     * @param request
     * @return
     */
    @RequestMapping("/findSickVisitInfo")
    public @ResponseBody Object findSickVisitInfo(HttpServletRequest request) {
        logger.info("findSickVisitInfo() is start");
        BaseResponseModel baseResponseModel = new BaseResponseModel();
        try {
            String requestStr = RequestValueUtil.parseRequestValue(request);
            SickVisitInfoVo sickVisitInfoVo = GsonUtil.strToObj(requestStr, SickVisitInfoVo.class);
            if (sickVisitInfoVo == null || StringUtils.isBlank(sickVisitInfoVo.getResidenceNo())) {
                baseResponseModel.setCode(responseCodeConstant.clinic_param_null);
                baseResponseModel.setMessage("客户端参数为null！");
                return baseResponseModel;
            }else {
                sickVisitInfoVo.setHospitalNumber(responseCodeConstant.hospital_number);
                SickVisitInfo sickVisitInfo = medicalViewService.findSickVisitInfo(sickVisitInfoVo);
                SickVisitInfoModel visitInfoModel = new SickVisitInfoModel();
                visitInfoModel.setData(sickVisitInfo);
                baseResponseModel.setBody(visitInfoModel);
                baseResponseModel.setCode(responseCodeConstant.success);
                baseResponseModel.setMessage("查询成功！");
            }
        } catch (Exception e) {
            String tmp = e.getMessage();
            baseResponseModel.setCode(responseCodeConstant.error);
            baseResponseModel.setMessage("服务器异常！异常信息为: " + tmp.substring(tmp.indexOf("ORA-"), tmp.indexOf("The") - 7));
            logger.info("服务器异常！异常信息为: " + tmp);
            e.printStackTrace();
        } finally {
            baseResponseModel.setResponseTime(new Date());
            logger.info("findSickVisitInfo() is end");
        }
        return baseResponseModel;
    }

    /**
     * 医保结算主信息视图
     * @param request
     * @return
     */
    @RequestMapping("/selectMedReceiptRecordMaster")
    public @ResponseBody Object selectMedReceiptRecordMaster(HttpServletRequest request){
        logger.info("selectMedReceiptRecordMaster() is start!");
        BaseResponseModel responseModel = new BaseResponseModel();
        try {
            String requestValue = RequestValueUtil.parseRequestValue(request);
            SickVisitInfoVo sickVisitInfoVo = GsonUtil.strToObj(requestValue, SickVisitInfoVo.class);
            if (sickVisitInfoVo == null) {
                responseModel.setCode(responseCodeConstant.clinic_param_null);
                responseModel.setMessage("客户端参数为null！");
                return responseModel;
            }else if(StringUtils.isBlank(sickVisitInfoVo.getResidenceNo()) && StringUtils.isBlank(sickVisitInfoVo.getVisitNumber())){
                responseModel.setCode(responseCodeConstant.clinic_param_null);
                responseModel.setMessage("客户端参数为null！");
                return responseModel;
            }else {
                sickVisitInfoVo.setHospitalNumber(responseCodeConstant.hospital_number);
                if(MagicValueConstant.one.equals(sickVisitInfoVo.getPayType())){
                    sickVisitInfoVo.setPayType(MagicValueConstant.one);
                }else if(MagicValueConstant.two.equals(sickVisitInfoVo.getPayType())){
                    sickVisitInfoVo.setPayType(MagicValueConstant.two);
                }else if(MagicValueConstant.three.equals(sickVisitInfoVo.getPayType())){
                    sickVisitInfoVo.setPayType(MagicValueConstant.three);
                }else {
                    sickVisitInfoVo.setPayType(MagicValueConstant.one);
                }
                MedReceiptRecordMasterModel medReceiptRecordMasterModel = new MedReceiptRecordMasterModel();
                MedReceiptRecordMaster medReceiptRecordMaster = medicalViewService.selectMedReceiptRecordMaster(sickVisitInfoVo);
                medReceiptRecordMasterModel.setData(medReceiptRecordMaster);
                responseModel.setBody(medReceiptRecordMasterModel);
                responseModel.setMessage("查询成功！");
                responseModel.setCode(responseCodeConstant.success);
            }
        }catch (Exception e){
            String message = e.getMessage();
            responseModel.setMessage("服务器异常！异常信息为: " + message.substring(message.indexOf("ORA-"), message.indexOf("The") - 7));
            responseModel.setCode(responseCodeConstant.error);
            logger.info("服务器异常！异常信息为: " + message);
            e.printStackTrace();
        }finally {
            responseModel.setResponseTime(new Date());
            logger.info("selectMedReceiptRecordMaster() is end!");
        }
        return responseModel;
    }


}
