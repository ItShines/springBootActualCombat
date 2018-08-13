package com.springboot.api.service;

import com.springboot.api.model.VisitInfoModel;
import com.springboot.api.vo.VisitInfoVo;

/**
 * @author Future
 */
public interface  MedicalService {

    VisitInfoVo findSickVisitInfo(VisitInfoVo visitInfoVo);
}
