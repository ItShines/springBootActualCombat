package com.springboot.api.service.impl;

import com.springboot.api.dao.MedicalInterfaceDatabaseDao;
import com.springboot.api.service.MedicalInterfaceDatabaseService;
import com.springboot.api.util.ResponseCodeConstant;
import com.springboot.api.vo.Kc27Vo;
import com.springboot.api.vo.Kc28Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Future
 */
@Service
public class MedicalInterfaceDatabaseServiceImpl implements MedicalInterfaceDatabaseService {

    @Autowired
    private ResponseCodeConstant responseCodeConstant;

    @Autowired
    private MedicalInterfaceDatabaseDao medicalInterfaceDatabaseDao;

    /**
     * 门诊费用批量保存接口
     * @param kc28VoList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int batchSaveKc28(List<Kc28Vo> kc28VoList) {
        return medicalInterfaceDatabaseDao.batchSaveKc28(kc28VoList);
    }

    /**
     * 住院费用批量保存接口
     * @param kc27VoList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int batchSaveKc27(List<Kc27Vo> kc27VoList) {
        return medicalInterfaceDatabaseDao.batchSaveKc27(kc27VoList);
    }
}
