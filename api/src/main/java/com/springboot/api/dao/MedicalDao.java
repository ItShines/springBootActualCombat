package com.springboot.api.dao;

import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.vo.SickVisitInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Future
 */
@Component
@Mapper
public interface MedicalDao {

    /**
     * 医保住院-查询是否医保中心登记
     * @param sickVisitInfoVo
     * @return
     */
    SickVisitInfo findSickVisitInfo(SickVisitInfoVo sickVisitInfoVo);
}
