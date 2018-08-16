package com.springboot.api.dao;

import com.springboot.api.vo.Kc27Vo;
import com.springboot.api.vo.Kc28Vo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Future
 */
@Component
@Mapper
public interface MedicalInterfaceDatabaseDao {
    /**
     * 门诊费用批量保存接口
     * @param kc28VoList
     * @return
     */
    int batchSaveKc28(List<Kc28Vo> kc28VoList);
    /**
     * 住院费用批量保存接口
     * @param kc27VoList
     * @return
     */
    int batchSaveKc27(List<Kc27Vo> kc27VoList);
}
