package com.springboot.api.entity;

import java.util.Date;

/**
 * 医保住院登记信息视图（SICK_VISIT_INFO）。用于查询住院登记信息
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
     *
     */


}
