package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 部门表 alarm_info
 * 
 * @author Polaris
 */
public class AlarmInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门ID */
    private Long infoId;

    /** 父部门ID */
    private Integer modelStatus;

    /** 祖级列表 */
    private String titleName;

    /** 部门名称 */
    private String level;

    /** 显示顺序 */
    private Long createUserId;

    /** 显示顺序 */
    private Long modifyUserId;

    /** 负责人 */
    private Date alarmTime;

    /** 联系电话 */
    private String content;

    private Date createTime;

    private Date modifyTime;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Integer getModelStatus() {
        return modelStatus;
    }

    public void setModelStatus(Integer modelStatus) {
        this.modelStatus = modelStatus;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "AlarmInfo{" +
                "infoId=" + infoId +
                ", modelStatus=" + modelStatus +
                ", titleName='" + titleName + '\'' +
                ", level='" + level + '\'' +
                ", createUserId=" + createUserId +
                ", modifyUserId=" + modifyUserId +
                ", alarmTime=" + alarmTime +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", attr1='" + attr1 + '\'' +
                ", attr2='" + attr2 + '\'' +
                ", attr3='" + attr3 + '\'' +
                ", attr4='" + attr4 + '\'' +
                ", attr5='" + attr5 + '\'' +
                '}';
    }
}
