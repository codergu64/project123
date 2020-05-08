package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 省市表 sys_city
 * 
 * @author Polaris
 */
public class SysCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 城市ID */
    private Long id;

    /** 父级ID */
    private Long pid;

    /** 城市名称 */
    private String cityName;

    /** 三级类型 0：全国 1：省（直辖市）2：市 3：区（县） */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SysCity{" +
                "id=" + id +
                ", pid=" + pid +
                ", cityName=" + cityName +
                ", type=" + type +
                '}';
    }
}
