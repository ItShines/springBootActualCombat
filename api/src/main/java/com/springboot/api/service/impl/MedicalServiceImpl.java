package com.springboot.api.service.impl;

import com.springboot.api.dao.MedicalDao;
import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.service.MedicalService;
import com.springboot.api.vo.SickVisitInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @author Future
 */
@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    private MedicalDao medicalDao;

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
    public SickVisitInfo findSickVisitInfo(SickVisitInfoVo sickVisitInfoVo) throws Exception {
        HashMap hashMap = medicalDao.selectDual(sickVisitInfoVo);
        SickVisitInfo sickVisitInfo = medicalDao.findSickVisitInfo(sickVisitInfoVo);
        return sickVisitInfo;
    }

}
