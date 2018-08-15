package com.springboot.api.service.impl;

import com.springboot.api.dao.MedicalViewDao;
import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.entity.ViewCode;
import com.springboot.api.service.MedicalViewService;
import com.springboot.api.util.FinalCodeConstant;
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
    private FinalCodeConstant finalCodeConstant;

    @Autowired
    private MedicalViewDao medicalViewDao;

    /**
     * 在查询目录视图前执行
     * @param
     * @return HashMap
     */
    public HashMap selectDual(){
        return medicalViewDao.selectDual(finalCodeConstant.hospital_number);
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

}
