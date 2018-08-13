package com.springboot.api.entity;

import java.util.Date;

/**
 * 医保住院接口表KC27
 * @author Future
 */
public class KC27{
    private static final long serialVersionUID = 1L;
    /**
     * 医疗机构编号
     */
    private String AKB020;
    /**
     * 住院号 医保结算系统录入的结算号
     */
    private String CKC179;
    /**
     * 结算号 给空值（由医保产生）
     */
    private String AKC190;
    /**
     * 处方号
     */
    private String AKC220 ;
    /**
     * 费用项目序号 NUMBER(6)
     */
    private String CKC158;
    /**
     * 经办人
     */
    private String AAE011;
    /**
     * 经办日期
     */
    private Date AAE036;
    /**
     * 收费项目类别
     */
    private String AKA063;
    /**
     * 收费项目代码
     */
    private String AKC222;
    /**
     * 收费项目名称
     */
    private String AKC223;
    /**
     * 金额(单价*数量后四舍五入保留两位小数) NUMBER(8,2)
     */
    private String AKC227;
    /**
     * 单价(不能小于等于0，最多四位小数) NUMBER(12,4)
     */
    private String CKC197;
    /**
     * 数量(不能小于等于0) NUMBER(6,2)
     */
    private String CKC198;
    /**
     * 规格(汉字，诊疗项目以“/”代替)
     */
    private String CKC159;
    /**
     * 计价单位 (代码 ，与医保计价单位一致，参考视图 “VIEW_CODE”)
     */
    private String CKC160;
    /**
     * 与中心对应关系医保收费项目的代码（视图PARA_CAPTURE_ITEM的ITEM_CODE）
     */
    private String CKC161;
    /**
     * 执行科室名称
     */
    private String CKC169;
    /**
     * 开方医生
     */
    private String CKC170;
    /**
     * 开放科室名称
     */
    private String CKC171;
    /**
     * 收据项目分类
     */
    private String CKE081;
    /**
     * 对应科室核算项目
     */
    private String CKE085;
    /**
     * 对应会计科目
     */
    private String CKE086;
    /**
     * 换算比例 (默认1) NUMBER(8,4)
     */
    private String CKE089;
    /**
     * 出院带药标志 (默认“在院用药”)
     */
    private String CKE090;
    /**
     * 是否医保项目(001是  000否)
     */
    private String SKA003;
    /**
     * 是否临床路径内项目 (1是临床路径内项目 0或者空默认不是临床路径内项目)
     */
    private String CKC188;

    public String getAKB020() {
        return AKB020;
    }

    public void setAKB020(String AKB020) {
        this.AKB020 = AKB020;
    }

    public String getCKC179() {
        return CKC179;
    }

    public void setCKC179(String CKC179) {
        this.CKC179 = CKC179;
    }

    public String getAKC190() {
        return AKC190;
    }

    public void setAKC190(String AKC190) {
        this.AKC190 = AKC190;
    }

    public String getAKC220() {
        return AKC220;
    }

    public void setAKC220(String AKC220) {
        this.AKC220 = AKC220;
    }

    public String getCKC158() {
        return CKC158;
    }

    public void setCKC158(String CKC158) {
        this.CKC158 = CKC158;
    }

    public String getAAE011() {
        return AAE011;
    }

    public void setAAE011(String AAE011) {
        this.AAE011 = AAE011;
    }

    public Date getAAE036() {
        return AAE036;
    }

    public void setAAE036(Date AAE036) {
        this.AAE036 = AAE036;
    }

    public String getAKA063() {
        return AKA063;
    }

    public void setAKA063(String AKA063) {
        this.AKA063 = AKA063;
    }

    public String getAKC222() {
        return AKC222;
    }

    public void setAKC222(String AKC222) {
        this.AKC222 = AKC222;
    }

    public String getAKC223() {
        return AKC223;
    }

    public void setAKC223(String AKC223) {
        this.AKC223 = AKC223;
    }

    public String getAKC227() {
        return AKC227;
    }

    public void setAKC227(String AKC227) {
        this.AKC227 = AKC227;
    }

    public String getCKC197() {
        return CKC197;
    }

    public void setCKC197(String CKC197) {
        this.CKC197 = CKC197;
    }

    public String getCKC198() {
        return CKC198;
    }

    public void setCKC198(String CKC198) {
        this.CKC198 = CKC198;
    }

    public String getCKC159() {
        return CKC159;
    }

    public void setCKC159(String CKC159) {
        this.CKC159 = CKC159;
    }

    public String getCKC160() {
        return CKC160;
    }

    public void setCKC160(String CKC160) {
        this.CKC160 = CKC160;
    }

    public String getCKC161() {
        return CKC161;
    }

    public void setCKC161(String CKC161) {
        this.CKC161 = CKC161;
    }

    public String getCKC169() {
        return CKC169;
    }

    public void setCKC169(String CKC169) {
        this.CKC169 = CKC169;
    }

    public String getCKC170() {
        return CKC170;
    }

    public void setCKC170(String CKC170) {
        this.CKC170 = CKC170;
    }

    public String getCKC171() {
        return CKC171;
    }

    public void setCKC171(String CKC171) {
        this.CKC171 = CKC171;
    }

    public String getCKE081() {
        return CKE081;
    }

    public void setCKE081(String CKE081) {
        this.CKE081 = CKE081;
    }

    public String getCKE085() {
        return CKE085;
    }

    public void setCKE085(String CKE085) {
        this.CKE085 = CKE085;
    }

    public String getCKE086() {
        return CKE086;
    }

    public void setCKE086(String CKE086) {
        this.CKE086 = CKE086;
    }

    public String getCKE089() {
        return CKE089;
    }

    public void setCKE089(String CKE089) {
        this.CKE089 = CKE089;
    }

    public String getCKE090() {
        return CKE090;
    }

    public void setCKE090(String CKE090) {
        this.CKE090 = CKE090;
    }

    public String getSKA003() {
        return SKA003;
    }

    public void setSKA003(String SKA003) {
        this.SKA003 = SKA003;
    }

    public String getCKC188() {
        return CKC188;
    }

    public void setCKC188(String CKC188) {
        this.CKC188 = CKC188;
    }
}
