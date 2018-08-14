package com.springboot.api.service;

import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.vo.SickVisitInfoVo;

/**
 * @author Future
 */
public interface  MedicalService {

    /**
     * 医保住院-查询是否医保中心登记
     *
     * @param sickVisitInfoVo
     * @return SickVisitInfo
     * @throws Exception
     */
    SickVisitInfo findSickVisitInfo(SickVisitInfoVo sickVisitInfoVo) throws Exception;
}
