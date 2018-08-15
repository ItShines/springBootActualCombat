package com.springboot.api.entity;

import java.util.Date;

/**
 * @author Future
 */
public class MedReceiptRecordMaster {
    /**
     * 医疗机构编号
     */
    private String hospitalNumber;
    /**
     * 结算号
     */
    private String chargeNumber;
    /**
     * 单位编号
     */
    private String unitNumber;
    /**
     * 个人编号
     */
    private String personalNumber;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private Date birthDate;
    /**
     * 人员类别
     */
    private String personalType;
    /**
     * 就诊类别
     */
    private String sickType;
    /**
     * 就诊方式
     */
    private String chargeSource;
    /**
     * 医院等级
     */
    private String hospitalGrade;
    /**
     * 本次住院次数
     */
    private String inCount;
    /**
     * 入院日期
     */
    private Date admissionDate;
    /**
     * 出院日期
     */
    private Date dischargeDate;
    /**
     * 入院诊断疾病编码
     */
    private String diagnosisName;
    /**
     * 本次住院号
     */
    private String residenceNo;
    /**
     * 医疗费总额
     */
    private String totalCost;
    /**
     * 本次起付线
     */
    private String payWave;
    /**
     * 现金支付金额
     */
    private String paySide1;
    /**
     * 个人帐户支付金额
     */
    private String paySide2;
    /**
     * 本次统筹应支付金额
     */
    private String paySide3;
    /**
     * 本次大病基金支付金额
     */
    private String paySide4;
    /**
     * 本次补充基金支付金额
     */
    private String paySide5;
    /**
     * 本次公务员津贴支付金额
     */
    private String paySide6;
    /**
     * 0
     */
    private String paySide7;
    /**
     * 0
     */
    private String paySide8;
    /**
     * 门诊处方号
     */
    private String visitNumber;
    /**
     * take_flag
     */
    private String takeFlag;
    /**
     * 经办日期
     */
    private Date handleDate;
    /**
     * 结算类型（1收费，2退费，3被退费）
     */
    private String payType;
    /**
     * 经办人
     */
    private String operator;
    /**
     * 救助新增支出
     */
    private String ckb002;
    /**
     * 贫困救助支出
     */
    private String ckb006;
    /**
     * 学生二次补偿
     */
    private String ckb012;

    /**
     * 门诊诊察费报销金额
     */
    private String ckb019;

    public String getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNumber(String hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(String chargeNumber) {
        this.chargeNumber = chargeNumber;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonalType() {
        return personalType;
    }

    public void setPersonalType(String personalType) {
        this.personalType = personalType;
    }

    public String getSickType() {
        return sickType;
    }

    public void setSickType(String sickType) {
        this.sickType = sickType;
    }

    public String getChargeSource() {
        return chargeSource;
    }

    public void setChargeSource(String chargeSource) {
        this.chargeSource = chargeSource;
    }

    public String getHospitalGrade() {
        return hospitalGrade;
    }

    public void setHospitalGrade(String hospitalGrade) {
        this.hospitalGrade = hospitalGrade;
    }

    public String getInCount() {
        return inCount;
    }

    public void setInCount(String inCount) {
        this.inCount = inCount;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public String getResidenceNo() {
        return residenceNo;
    }

    public void setResidenceNo(String residenceNo) {
        this.residenceNo = residenceNo;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getPayWave() {
        return payWave;
    }

    public void setPayWave(String payWave) {
        this.payWave = payWave;
    }

    public String getPaySide1() {
        return paySide1;
    }

    public void setPaySide1(String paySide1) {
        this.paySide1 = paySide1;
    }

    public String getPaySide2() {
        return paySide2;
    }

    public void setPaySide2(String paySide2) {
        this.paySide2 = paySide2;
    }

    public String getPaySide3() {
        return paySide3;
    }

    public void setPaySide3(String paySide3) {
        this.paySide3 = paySide3;
    }

    public String getPaySide4() {
        return paySide4;
    }

    public void setPaySide4(String paySide4) {
        this.paySide4 = paySide4;
    }

    public String getPaySide5() {
        return paySide5;
    }

    public void setPaySide5(String paySide5) {
        this.paySide5 = paySide5;
    }

    public String getPaySide6() {
        return paySide6;
    }

    public void setPaySide6(String paySide6) {
        this.paySide6 = paySide6;
    }

    public String getPaySide7() {
        return paySide7;
    }

    public void setPaySide7(String paySide7) {
        this.paySide7 = paySide7;
    }

    public String getPaySide8() {
        return paySide8;
    }

    public void setPaySide8(String paySide8) {
        this.paySide8 = paySide8;
    }

    public String getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(String visitNumber) {
        this.visitNumber = visitNumber;
    }

    public String getTakeFlag() {
        return takeFlag;
    }

    public void setTakeFlag(String takeFlag) {
        this.takeFlag = takeFlag;
    }

    public Date getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(Date handleDate) {
        this.handleDate = handleDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCkb002() {
        return ckb002;
    }

    public void setCkb002(String ckb002) {
        this.ckb002 = ckb002;
    }

    public String getCkb006() {
        return ckb006;
    }

    public void setCkb006(String ckb006) {
        this.ckb006 = ckb006;
    }

    public String getCkb012() {
        return ckb012;
    }

    public void setCkb012(String ckb012) {
        this.ckb012 = ckb012;
    }

    public String getCkb019() {
        return ckb019;
    }

    public void setCkb019(String ckb019) {
        this.ckb019 = ckb019;
    }
}
