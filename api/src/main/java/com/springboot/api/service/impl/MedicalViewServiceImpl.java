package com.springboot.api.service.impl;

import com.springboot.api.dao.MedicalViewDao;
import com.springboot.api.entity.MedReceiptRecordMaster;
import com.springboot.api.entity.ParaCaptureItem;
import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.entity.ViewCode;
import com.springboot.api.service.MedicalViewService;
import com.springboot.api.util.ResponseCodeConstant;
import com.springboot.api.vo.SickVisitInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author Future
 */
@Service
public class MedicalViewServiceImpl implements MedicalViewService {

    @Autowired
    private ResponseCodeConstant responseCodeConstant;

    @Autowired
    private MedicalViewDao medicalViewDao;

    /**
     * 在查询目录视图前执行
     * @param
     * @return HashMap
     */
    public HashMap selectDual(){
        return medicalViewDao.selectDual(responseCodeConstant.hospital_number);
    }
    /**
     * 查询项目名称与代码的对应关系
     * @return List<ViewCode>
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<ViewCode> selectViewCode(){
        selectDual();
        return medicalViewDao.selectViewCode();
    }

    /**
     * 医保收费项目目录视图
     * @return List<ParaCaptureItem>
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<ParaCaptureItem> selectParaCaptureItem(){
        selectDual();
        return medicalViewDao.selectParaCaptureItem();
    }

    /**
     * 医保住院-查询是否医保中心登记
     * RESIDENCE_NO：住院号
     * HOSPITAL_NUMBER：医院编号
     * 两个参数为必填项！
     * @param sickVisitInfoVo
     * @return SickVisitInfo
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public SickVisitInfo findSickVisitInfo(SickVisitInfoVo sickVisitInfoVo){
        selectDual();
        SickVisitInfo sickVisitInfo = medicalViewDao.findSickVisitInfo(sickVisitInfoVo);
        return sickVisitInfo;
    }

    /**
     * 医保结算主信息视图
     * 获取门诊、住院结算信息
     * @param sickVisitInfoVo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public MedReceiptRecordMaster selectMedReceiptRecordMaster(SickVisitInfoVo sickVisitInfoVo) {
        selectDual();
        return medicalViewDao.selectMedReceiptRecordMaster(sickVisitInfoVo);
    }

}
