package com.springboot.api.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springboot.api.service.MedicalInterfaceDatabaseService;
import com.springboot.api.util.*;
import com.springboot.api.vo.Kc27Vo;
import com.springboot.api.vo.Kc28Vo;
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
 * 接口数据
 *
 * @author Future
 */
@RestController
@RequestMapping("/interfaceDatabase")
public class MedicalInterfaceDatabaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResponseCodeConstant responseCodeConstant;

    @Autowired
    private MedicalInterfaceDatabaseService medicalInterfaceDatabaseService;

    /**
     * 门诊费用批量保存接口
     *
     * @return
     */
    @RequestMapping("/saveKc28")
    public @ResponseBody
    Object saveKc28(HttpServletRequest request) {
        logger.info("saveKc28() is start!");
        BaseResponseModel responseModel = new BaseResponseModel();
        try {
            String requestValue = RequestValueUtil.parseRequestValue(request);
            List<Kc28Vo> kc28VoList = new Gson().fromJson(requestValue, new TypeToken<List<Kc28Vo>>() {
            }.getType());
            //TODO 数据未做处理 不一定符合数据要求 此时数据可分在不同的服务器处理
            int i = medicalInterfaceDatabaseService.batchSaveKc28(kc28VoList);
            if (i > 0) {
                responseModel.setCode(responseCodeConstant.success);
                responseModel.setMessage("添加成功！");
            } else {
                responseModel.setCode(responseCodeConstant.error);
                responseModel.setMessage("服务器异常!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            responseModel.setMessage("服务器异常！异常信息为: " + message.substring(message.indexOf("ORA-"), message.indexOf("The") - 7));
            responseModel.setCode(responseCodeConstant.error);
            logger.info("服务器异常！异常信息为: " + message);
        } finally {
            responseModel.setResponseTime(new Date());
            logger.info("saveKc28() is end!");
        }
        return responseModel;
    }


    /**
     * 住院费用批量保存接口
     *
     * @return
     */
    @RequestMapping("/saveKc27")
    public @ResponseBody
    Object saveKc27(HttpServletRequest request) {
        logger.info("saveKc27() is start!");
        BaseResponseModel responseModel = new BaseResponseModel();
        try {
            String requestValue = RequestValueUtil.parseRequestValue(request);
            List<Kc27Vo> kc27VoList = new Gson().fromJson(requestValue, new TypeToken<List<Kc27Vo>>() {
            }.getType());
            //TODO 数据未做处理 不一定符合数据要求 此时数据可分在不同的服务器处理
            BaseResponseModel responseModelResult = medicalInterfaceDatabaseService.batchSaveKc27(kc27VoList);
            if (responseCodeConstant.success.equals(responseModelResult.getCode())) {
                responseModel.setCode(responseCodeConstant.success);
                responseModel.setMessage("添加成功!");
            } else {
                responseModel.setCode(responseCodeConstant.error);
                responseModel.setMessage("服务器异常！异常信息为: " + responseModelResult.getMessage());
            }
        } catch (Exception e) {
            String message = e.getMessage();
            e.printStackTrace();
            responseModel.setMessage("服务器异常！异常信息为: " + message.substring(message.indexOf("ORA-"), message.indexOf("The") - 7));
            responseModel.setCode(responseCodeConstant.error);
            logger.info("服务器异常！异常信息为: " + message);
        } finally {
            responseModel.setResponseTime(new Date());
            logger.info("saveKc27() is end!");
        }
        return responseModel;
    }
}
