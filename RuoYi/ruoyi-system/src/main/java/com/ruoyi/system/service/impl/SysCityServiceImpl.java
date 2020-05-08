package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysCity;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.mapper.SysCityMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.service.ISysCityService;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 城市信息
 * 
 * @author Polaris
 */
@Service
public class SysCityServiceImpl implements ISysCityService
{

    @Resource
    private SysCityMapper cityMapper;

    @Override
    @DataScope(deptAlias = "c")
    public List<Ztree> selectCityTree(SysCity city) {
        List<SysCity> cityList = cityMapper.selectCityList(city);
        List<Ztree> ztrees = initZtree(cityList);
        return ztrees;
    }

    /**
     * 对象转部门树
     *
     * @param cityList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysCity> cityList)
    {
        List<Ztree> ztrees = new ArrayList<>();
        for (SysCity sysCity : cityList) {
            Ztree ztree = new Ztree();
            ztree.setId(sysCity.getId());
            ztree.setpId(sysCity.getPid());
            ztree.setName(sysCity.getCityName());
            ztree.setTitle(sysCity.getCityName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public SysCity selectCityById(Long cityId) {
        return cityMapper.selectCityById(cityId);
    }
}
