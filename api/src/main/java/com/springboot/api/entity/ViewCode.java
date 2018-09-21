package com.springboot.api.entity;

import java.io.Serializable;

/**
 * 代码视图（VIEW_CODE）,该视图可查询项目名称与代码的对应关系
 *
 * @author Future
 */
public class ViewCode implements Serializable {

    private static final long serialVersionUID = 2L;
    /**
     * 代码类别，包括（行政区划、人员类别、收费项目等级、计价单位、就诊方式、剂型）等
     * VARCHAR2(50)
     */
    private String AAA002;
    /**
     * 代码
     * VARCHAR2(20)
     */
    private String AAA003;
    /**
     * 代码名称
     * VARCHAR2(400)
     */
    private String AAA004;
    /**
     * 当前有效标志（1有效0无效）
     * VARCHAR2(3)
     */
    private String AAE100;
    /**
     * 备用字段
     * VARCHAR2(20)
     */
    private String CAA001;

    public String getAAA002() {
        return AAA002;
    }

    public void setAAA002(String AAA002) {
        this.AAA002 = AAA002;
    }

    public String getAAA003() {
        return AAA003;
    }

    public void setAAA003(String AAA003) {
        this.AAA003 = AAA003;
    }

    public String getAAA004() {
        return AAA004;
    }

    public void setAAA004(String AAA004) {
        this.AAA004 = AAA004;
    }

    public String getAAE100() {
        return AAE100;
    }

    public void setAAE100(String AAE100) {
        this.AAE100 = AAE100;
    }

    public String getCAA001() {
        return CAA001;
    }

    public void setCAA001(String CAA001) {
        this.CAA001 = CAA001;
    }
}
