package com.springboot.api.service.impl;

import com.springboot.api.dao.MedicalDao;
import com.springboot.api.model.VisitInfoModel;
import com.springboot.api.service.MedicalService;
import com.springboot.api.vo.VisitInfoVo;
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
     */
    @Transactional
    @Override
    public VisitInfoVo findSickVisitInfo(VisitInfoVo visitInfoVo){
//        hashMap.put("HOSPITAL_NUMBER", HOSPITAL_NUMBER);//医疗机构编号
//        hashMap.put("RESIDENCE_NO", residence_no);//医保中心住院号
//        VisitInfoVo baseDto1 = medicalDao.selectParaCaptureItem(hashMap);//医保联通
//        VisitInfoVo baseDto = medicalDao.selectSickVisitInfo(hashMap);

        return visitInfoVo;
    }

}
