package com.springboot.api.vo;

/**
 * 接收查询住院登记信息参数
 * 接收医保结算主信息视图参数,包含门诊住院
 *
 * @author Future
 */
public class SickVisitInfoVo {
    /**
     * 结算类型（1收费，2退费，3被退费）
     */
    private String payType;

    /**
     * 门诊处方号
     */
    private String visitNumber;

    /**
     * 患者医保住院登记号
     * 本次住院号
     */
    private String residenceNo;

    /**
     * 医院编号
     */
    private String hospitalNumber;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(String visitNumber) {
        this.visitNumber = visitNumber;
    }

    public String getResidenceNo() {
        return residenceNo;
    }

    public void setResidenceNo(String residenceNo) {
        this.residenceNo = residenceNo;
    }

    public String getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNumber(String hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }
}
