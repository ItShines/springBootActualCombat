package com.springboot.api.entity;

import java.util.Date;

/**
 * 医保住院登记信息视图（SICK_VISIT_INFO）。用于查询住院登记信息
 *
 * @author Future
 */
public class SickVisitInfo {
    /**
     * 行政区划编号
     */
    private String areaid;

    /**
     * 医疗机构编号
     */
    private String hospitalNumber;

    /**
     * 个人编号
     */
    private String personalNumber;

    /**
     * 身份证号
     */
    private String personalIc;

    /**
     * 入院日期
     */
    private Date admissionDate;

    /**
     * 单位编号
     */
    private String unitNumber;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别(1:男，2:女)
     */
    private String sex;

    /**
     * 出生年月
     */
    private Date birthmonth;

    /**
     * 住院号
     */
    private String residenceNo;

    /**
     * 人员类别
     */
    private String personalType;

    /**
     * 就诊类型
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
     * 出院日期
     */
    private String dischargeDate;

    /**
     * 入院科室
     */
    private String admissionDept;

    /**
     * 出院科室
     */
    private String dischargeDept;

    /**
     * 入院诊断疾病
     */
    private String diagnosisNamein;

    /**
     * 出院院诊断疾病
     */
    private String diagnosisNameout;

    /**
     * 房间号
     */
    private String roomNo;

    /**
     * 床号
     */
    private String bedNo;

    /**
     * 结算日期
     */
    private Date balDate;

    /**
     * 地址
     */
    private String contactAddress;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 入院科室名称
     */
    private String inDeptName;

    /**
     * 出院科室名称
     */
    private String outDeptName;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 经办日期
     */
    private Date operateDate;

    /**
     * 备注
     */
    private String memo;

    /**
     * 结算号
     */
    private String chargeNumber;

    /**
     * 险种（301职工， 501生育，801居民）
     */
    private String insuranceType;

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNumber(String hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getPersonalIc() {
        return personalIc;
    }

    public void setPersonalIc(String personalIc) {
        this.personalIc = personalIc;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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

    public Date getBirthmonth() {
        return birthmonth;
    }

    public void setBirthmonth(Date birthmonth) {
        this.birthmonth = birthmonth;
    }

    public String getResidenceNo() {
        return residenceNo;
    }

    public void setResidenceNo(String residenceNo) {
        this.residenceNo = residenceNo;
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

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getAdmissionDept() {
        return admissionDept;
    }

    public void setAdmissionDept(String admissionDept) {
        this.admissionDept = admissionDept;
    }

    public String getDischargeDept() {
        return dischargeDept;
    }

    public void setDischargeDept(String dischargeDept) {
        this.dischargeDept = dischargeDept;
    }

    public String getDiagnosisNamein() {
        return diagnosisNamein;
    }

    public void setDiagnosisNamein(String diagnosisNamein) {
        this.diagnosisNamein = diagnosisNamein;
    }

    public String getDiagnosisNameout() {
        return diagnosisNameout;
    }

    public void setDiagnosisNameout(String diagnosisNameout) {
        this.diagnosisNameout = diagnosisNameout;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public Date getBalDate() {
        return balDate;
    }

    public void setBalDate(Date balDate) {
        this.balDate = balDate;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getInDeptName() {
        return inDeptName;
    }

    public void setInDeptName(String inDeptName) {
        this.inDeptName = inDeptName;
    }

    public String getOutDeptName() {
        return outDeptName;
    }

    public void setOutDeptName(String outDeptName) {
        this.outDeptName = outDeptName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(String chargeNumber) {
        this.chargeNumber = chargeNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
}
