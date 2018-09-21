package com.springboot.api.service;

import com.springboot.api.entity.MedReceiptRecordMaster;
import com.springboot.api.entity.ParaCaptureItem;
import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.entity.ViewCode;
import com.springboot.api.vo.SickVisitInfoVo;

import java.util.List;

/**
 * @author Future
 */
public interface MedicalViewService {

    /**
     * 查询项目名称与代码的对应关系
     *
     * @return List<ViewCode>
     * @throws Exception
     */
    List<ViewCode> selectViewCode();

    /**
     * 医保收费项目目录视图
     *
     * @return List<ParaCaptureItem>
     */
    List<ParaCaptureItem> selectParaCaptureItem();

    /**
     * 医保住院-查询是否医保中心登记
     *
     * @param sickVisitInfoVo
     * @return SickVisitInfo
     * @throws Exception
     */
    SickVisitInfo findSickVisitInfo(SickVisitInfoVo sickVisitInfoVo);

    /**
     * 医保结算主信息视图
     * 获取门诊、住院结算信息
     *
     * @param sickVisitInfoVo
     * @return
     */
    MedReceiptRecordMaster selectMedReceiptRecordMaster(SickVisitInfoVo sickVisitInfoVo);
}
