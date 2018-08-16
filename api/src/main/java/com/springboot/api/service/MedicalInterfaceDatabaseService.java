package com.springboot.api.service;

import com.springboot.api.vo.Kc27Vo;
import com.springboot.api.vo.Kc28Vo;

import java.util.List;

/**
 * 接口数据
 * @author Future
 */
public interface MedicalInterfaceDatabaseService {

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
