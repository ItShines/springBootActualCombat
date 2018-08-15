package com.springboot.api.entity;

/**
 * 医保收费项目目录视图（PARA_CAPTURE_ITEM）
 * 该视图中的字段“ITEM_CODE”为收费项目的唯一编码，
 * 医院HIS需要在自己的收费项目表中扩展一个字段与其进行对应关系维护，
 * 并在录入处方时在处方明细表中写入该字段
 * @author Future
 */
public class ParaCaptureItem {

    /**
     * 收费项目类别 VARCHAR2(3)
     */
    private String itemType;

    /**
     * 项目代码 VARCHAR2(20)
     */
    private String itemCode;

    /**
     * 项目名称 VARCHAR2(100)
     */
    private String itemName;

    /**
     * 项目规格 VARCHAR2(300)
     */
    private String itemSpec;

    /**
     * 剂型代码 VARCHAR2(3)
     */
    private String itemFormCode;

    /**
     * 剂型 VARCHAR2(50)
     */
    private String itemForm;

    /**
     * 剂量单位代码 VARCHAR2(3)
     */
    private String priceUnitCode;

    /**
     * 剂量单位VARCHAR2(50)
     */
    private String priceUnit;

    /**
     * 生产单位 VARCHAR2(100)
     */
    private String productionUnit;

    /**
     * 批准文号 VARCHAR2(20)
     */
    private String approvalNumber;

    /**
     * 项目通用名 VARCHAR2(100)
     */
    private String commonName;

    /**
     * 助记码 VARCHAR2(100)
     */
    private String mnemonic;

    /**
     * 处方药标志 VARCHAR2(3)
     */
    private String reciptFlag;

    /**
     * 统计类别 VARCHAR2(3)
     */
    private String sumaryType;

    /**
     * 职工项目等级（VIEW_CODE视图“收费项目等级”）VARCHAR2(3)
     */
    private String itemGrade301;

    /**
     * 预留不使用 VARCHAR2(3)
     */
    private String itemGrade401;

    /**
     * 生育项目等级（VIEW_CODE视图“收费项目等级”）VARCHAR2(3)
     */
    private String itemGrade501;

    /**
     * 居民项目等级（VIEW_CODE视图“收费项目等级”）VARCHAR2(3)
     */
    private String itemGrade801;

    /**
     * 职工有效标志（1表示该目录已删除；0表示有效）VARCHAR2(1)
     */
    private String deleteFlag301;

    /**
     * 预留不使用 VARCHAR2(1)
     */
    private String deleteFlag401;

    /**
     * 生育有效标志（1表示该目录已删除；0表示有效）VARCHAR2(1)
     */
    private String  deleteFlag501;

    /**
     * 居民有效标志（1表示该目录已删除；0表示有效）VARCHAR2(1)
     */
    private String deleteFlag801;

    /**
     * 一类限价(对应省级收费) NUMBER(10,4)
     */
    private String priceMax1;

    /**
     * 二类限价(对应市级收费) NUMBER(10,4)
     */
    private String priceMax2;

    /**
     * 三类限价(对应县级收费) NUMBER(10,4)
     */
    private String priceMax3;

    /**
     * 预留不使用 NUMBER(10,4)
     */
    private String priceMax4;

    /**
     * 预留不使用 NUMBER(10,4)
     */
    private String priceMax5;

    /**
     * 预留不使用 NUMBER(10,4)
     */
    private String priceMax6;

    /**
     * 医疗机构限价	NUMBER(10,4)
     */
    private String hospitalMax;

    /**
     * 收费限制说明(代码) VARCHAR2(6)
     */
    private String limitType;

    /**
     * 收费限制说明(中文) VARCHAR2(200)
     */
    private String limitName;

    /**
     * 门诊收据	VARCHAR2(3)
     */
    private String clinicReceipt;

    /**
     * 住院收据	VARCHAR2(3)
     */
    private String inhReceipt;

    /**
     * 备注	VARCHAR2(500)
     */
    private String remarks;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public String getItemFormCode() {
        return itemFormCode;
    }

    public void setItemFormCode(String itemFormCode) {
        this.itemFormCode = itemFormCode;
    }

    public String getItemForm() {
        return itemForm;
    }

    public void setItemForm(String itemForm) {
        this.itemForm = itemForm;
    }

    public String getPriceUnitCode() {
        return priceUnitCode;
    }

    public void setPriceUnitCode(String priceUnitCode) {
        this.priceUnitCode = priceUnitCode;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getProductionUnit() {
        return productionUnit;
    }

    public void setProductionUnit(String productionUnit) {
        this.productionUnit = productionUnit;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getReciptFlag() {
        return reciptFlag;
    }

    public void setReciptFlag(String reciptFlag) {
        this.reciptFlag = reciptFlag;
    }

    public String getSumaryType() {
        return sumaryType;
    }

    public void setSumaryType(String sumaryType) {
        this.sumaryType = sumaryType;
    }

    public String getItemGrade301() {
        return itemGrade301;
    }

    public void setItemGrade301(String itemGrade301) {
        this.itemGrade301 = itemGrade301;
    }

    public String getItemGrade401() {
        return itemGrade401;
    }

    public void setItemGrade401(String itemGrade401) {
        this.itemGrade401 = itemGrade401;
    }

    public String getItemGrade501() {
        return itemGrade501;
    }

    public void setItemGrade501(String itemGrade501) {
        this.itemGrade501 = itemGrade501;
    }

    public String getItemGrade801() {
        return itemGrade801;
    }

    public void setItemGrade801(String itemGrade801) {
        this.itemGrade801 = itemGrade801;
    }

    public String getDeleteFlag301() {
        return deleteFlag301;
    }

    public void setDeleteFlag301(String deleteFlag301) {
        this.deleteFlag301 = deleteFlag301;
    }

    public String getDeleteFlag401() {
        return deleteFlag401;
    }

    public void setDeleteFlag401(String deleteFlag401) {
        this.deleteFlag401 = deleteFlag401;
    }

    public String getDeleteFlag501() {
        return deleteFlag501;
    }

    public void setDeleteFlag501(String deleteFlag501) {
        this.deleteFlag501 = deleteFlag501;
    }

    public String getDeleteFlag801() {
        return deleteFlag801;
    }

    public void setDeleteFlag801(String deleteFlag801) {
        this.deleteFlag801 = deleteFlag801;
    }

    public String getPriceMax1() {
        return priceMax1;
    }

    public void setPriceMax1(String priceMax1) {
        this.priceMax1 = priceMax1;
    }

    public String getPriceMax2() {
        return priceMax2;
    }

    public void setPriceMax2(String priceMax2) {
        this.priceMax2 = priceMax2;
    }

    public String getPriceMax3() {
        return priceMax3;
    }

    public void setPriceMax3(String priceMax3) {
        this.priceMax3 = priceMax3;
    }

    public String getPriceMax4() {
        return priceMax4;
    }

    public void setPriceMax4(String priceMax4) {
        this.priceMax4 = priceMax4;
    }

    public String getPriceMax5() {
        return priceMax5;
    }

    public void setPriceMax5(String priceMax5) {
        this.priceMax5 = priceMax5;
    }

    public String getPriceMax6() {
        return priceMax6;
    }

    public void setPriceMax6(String priceMax6) {
        this.priceMax6 = priceMax6;
    }

    public String getHospitalMax() {
        return hospitalMax;
    }

    public void setHospitalMax(String hospitalMax) {
        this.hospitalMax = hospitalMax;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getLimitName() {
        return limitName;
    }

    public void setLimitName(String limitName) {
        this.limitName = limitName;
    }

    public String getClinicReceipt() {
        return clinicReceipt;
    }

    public void setClinicReceipt(String clinicReceipt) {
        this.clinicReceipt = clinicReceipt;
    }

    public String getInhReceipt() {
        return inhReceipt;
    }

    public void setInhReceipt(String inhReceipt) {
        this.inhReceipt = inhReceipt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
