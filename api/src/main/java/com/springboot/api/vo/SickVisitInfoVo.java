package com.springboot.api.vo;

/**
 * 接收查询住院登记信息参数
 * @author Future
 */
public class SickVisitInfoVo {
    /**
     * 患者医保住院登记号
     */
    private String residenceNo;
    /**
     * 医院编号
     */
    private String hospitalNumber;

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
