package com.springboot.api.service.impl;

import com.springboot.api.dao.MedicalInterfaceDatabaseDao;
import com.springboot.api.service.MedicalInterfaceDatabaseService;
import com.springboot.api.util.BaseResponseModel;
import com.springboot.api.util.MagicValueConstant;
import com.springboot.api.util.ResponseCodeConstant;
import com.springboot.api.vo.Kc27Vo;
import com.springboot.api.vo.Kc28Vo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * mybatis批量添加有数量限制小于2000条
 *
 * @author Future
 */
@Service
public class MedicalInterfaceDatabaseServiceImpl implements MedicalInterfaceDatabaseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResponseCodeConstant responseCodeConstant;

    @Autowired
    private MedicalInterfaceDatabaseDao medicalInterfaceDatabaseDao;

    /**
     * 门诊费用批量保存接口
     *
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
     *
     * @param kc27VoList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResponseModel batchSaveKc27(List<Kc27Vo> kc27VoList) {
        BaseResponseModel responseModel = handleKc27VoList(kc27VoList);
        if (responseCodeConstant.success.equals(responseModel.getCode())) {
            int i = medicalInterfaceDatabaseDao.batchSaveKc27(kc27VoList);
            logger.info("成功添加执行了" + i + "条,共" + kc27VoList.size() + "条");
        } else {
            logger.info("服务器异常！异常信息为: " + responseModel.getMessage());
        }
        return responseModel;
    }

    public BaseResponseModel handleKc27VoList(List<Kc27Vo> kc27VoList) {
        BaseResponseModel responseModel = new BaseResponseModel();
        StringBuffer errorMessage = new StringBuffer("住院接口所接参数列表中的下标为");
        for (int i = 0; i < kc27VoList.size(); i++) {
            Kc27Vo kc27Vo = kc27VoList.get(i);
            //机构号
            kc27Vo.setAKB020(responseCodeConstant.hospital_number);
            //给空值（由医保产生）
            kc27Vo.setAKC190(" ");
            //住院号
            if (StringUtils.isBlank(kc27Vo.getCKC179())) {
                errorMessage.append(i + "的住院号为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            errorMessage.append(i + "的住院号为" + kc27Vo.getCKC179() + "的患者的");
            //处方号
            if (StringUtils.isBlank(kc27Vo.getAKC220())) {
                errorMessage.append("处方号为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //费用项目序号
            kc27Vo.setCKC158(i + MagicValueConstant.intOne);
            errorMessage.append("处方号为" + kc27Vo.getAKC220() + "的");
            //经办人
            if (StringUtils.isBlank(kc27Vo.getAAE011())) {
                errorMessage.append("经办人为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //经办日期
            if (StringUtils.isBlank(kc27Vo.getAAE036())) {
                errorMessage.append("经办日期为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //收费项目类别
            if (StringUtils.isBlank(kc27Vo.getAKA063())) {
                errorMessage.append("收费项目类别为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //收费项目代码
            if (StringUtils.isBlank(kc27Vo.getAKC222())) {
                errorMessage.append("收费项目代码为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //收费项目名称
            if (StringUtils.isBlank(kc27Vo.getAKC223())) {
                errorMessage.append("收费项目名称为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //规格
            if (StringUtils.isBlank(kc27Vo.getCKC159())) {
                errorMessage.append("规格为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //计价单位
            if (StringUtils.isBlank(kc27Vo.getCKC160())) {
                errorMessage.append("计价单位为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //执行科室名称
            if (StringUtils.isBlank(kc27Vo.getCKC169())) {
                errorMessage.append("执行科室名称为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //开方医生
            if (StringUtils.isBlank(kc27Vo.getCKC170())) {
                errorMessage.append("开方医生为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //开方科室名称
            if (StringUtils.isBlank(kc27Vo.getCKC171())) {
                errorMessage.append("开方科室名称为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //收据项目分类
            if (StringUtils.isBlank(kc27Vo.getCKE081())) {
                errorMessage.append("收据项目分类为空");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            //单价
            if (kc27Vo.getCKC197() <= MagicValueConstant.intZero) {
                errorMessage.append("单价等于或小于零");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            double ckc197_v = roundDouble(kc27Vo.getCKC197(), 10000, 4);
            kc27Vo.setCKC197(ckc197_v);
            BigDecimal ckc197 = new BigDecimal(String.valueOf(ckc197_v));
            //数量
            if (kc27Vo.getCKC198() == MagicValueConstant.intZero) {
                errorMessage.append("数量为0");
                responseModel.setCode(responseCodeConstant.error);
                break;
            }
            double ckc198_v = roundDouble(kc27Vo.getCKC198(), 100, 2);
            kc27Vo.setCKC198(ckc198_v);
            BigDecimal ckc198 = new BigDecimal(ckc198_v);
            //金额
            kc27Vo.setAKC227(roundDouble(ckc197.multiply(ckc198).doubleValue(), 100, 2));
            errorMessage = new StringBuffer();
            responseModel.setCode(responseCodeConstant.success);
        }
        responseModel.setMessage(errorMessage.toString());
        return responseModel;
    }

    /**
     * 四舍五入保留两位小数
     *
     * @param b1    要保留的参数
     * @param b2    保留位数对应的10的幂数
     * @param scale 保留位数
     * @return
     */
    public static double roundDouble(double b1, double b2, int scale) {
        BigDecimal b = new BigDecimal(b1);
        BigDecimal bc = new BigDecimal(b2);
        double result = b.multiply(bc).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        BigDecimal bigDecimal = new BigDecimal(result);
        return bigDecimal.divide(bc, scale, RoundingMode.HALF_UP).doubleValue();
    }
}
