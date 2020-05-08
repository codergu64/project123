package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysCity;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.service.ISysCityService;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 省市信息
 * 
 * @author Polaris
 */
@Controller
@RequestMapping("/system/city")
public class SysCityController extends BaseController
{
    private String prefix = "system/city";

    @Autowired
    private ISysCityService cityService;

    @GetMapping("/cityTree")
    @ResponseBody
    public List<Ztree> cityData()
    {
        List<Ztree> cityTree = cityService.selectCityTree(new SysCity());
        return cityTree;
    }

    /**
     * 选择区域树
     */
    @GetMapping("/selectCityTree/{cityId}")
    public String selectCityTree(@PathVariable("cityId") Long cityId, ModelMap mmap)
    {
        mmap.put("city", cityService.selectCityById(cityId));
        return prefix + "/tree";
    }

    /**
     * 加载区域列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = cityService.selectCityTree(new SysCity());
        return ztrees;
    }
}
