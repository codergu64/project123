package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.SysCity;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;

import java.util.List;

/**
 * 城市管理 服务层
 * 
 * @author Polaris
 */
public interface ISysCityService
{

    /**
     * 查询城市树
     * 
     * @param city 城市信息
     * @return 所有城市信息
     */
    public List<Ztree> selectCityTree(SysCity city);

    public SysCity selectCityById(Long cityId);
}
