package com.springboot.api.dao;

import com.springboot.api.entity.SickVisitInfo;
import com.springboot.api.entity.ViewCode;
import com.springboot.api.vo.SickVisitInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author Future
 */
@Component
@Mapper
public interface MedicalViewDao {
    /**
     * 在查询目录视图前执行
     * @param sickVisitInfoVo
     * @return HashMap
     */
    HashMap selectDual(SickVisitInfoVo sickVisitInfoVo);

    /**
     * 查询项目名称与代码的对应关系
     * @return List<ViewCode>
     */
    List<ViewCode> selectViewCode();

    /**
     * 医保住院-查询是否医保中心登记
     * @param sickVisitInfoVo
     * @return SickVisitInfo
     */
    SickVisitInfo findSickVisitInfo(SickVisitInfoVo sickVisitInfoVo);
}
