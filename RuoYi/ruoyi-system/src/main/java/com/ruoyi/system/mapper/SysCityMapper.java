package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysCity;
import com.ruoyi.system.domain.SysDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门管理 数据层
 * 
 * @author ruoyi
 */
public interface SysCityMapper {
    /**
     * 查询部门管理数据
     *
     * @param city 部门信息
     * @return 部门信息集合
     */
    public List<SysCity> selectCityList(SysCity city);

    public SysCity selectCityById(@Param("cityId") Long cityId);
}
