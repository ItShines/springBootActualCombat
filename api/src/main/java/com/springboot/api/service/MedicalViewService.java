package com.springboot.api.service;

import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.entity.ViewCode;
import com.springboot.api.vo.SickVisitInfoVo;

import java.util.List;

/**
 * @author Future
 */
public interface  MedicalViewService {

    /**
     * 查询项目名称与代码的对应关系
     * @return List<ViewCode>
     */
    List<ViewCode> selectViewCode();
    /**
     * 医保住院-查询是否医保中心登记
     *
     * @param sickVisitInfoVo
     * @return SickVisitInfo
     * @throws Exception
     */
    SickVisitInfo findSickVisitInfo(SickVisitInfoVo sickVisitInfoVo) throws Exception;
}
