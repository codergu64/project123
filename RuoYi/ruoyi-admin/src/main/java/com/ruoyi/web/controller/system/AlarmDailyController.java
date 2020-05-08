package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.AlarmInfo;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.service.IAlarmInfoService;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/alarm/daily")
public class AlarmDailyController extends BaseController
{
    private String prefix = "alarm/daily";

    @Resource
    private IAlarmInfoService alarmInfoService;

    @RequiresPermissions("alarm:daily:view")
    @GetMapping()
    public String daily()
    {
        return prefix + "/daily";
    }

    @RequiresPermissions("alarm:daily:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AlarmInfo alarmInfo) {
        startPage();
        List<AlarmInfo> alarmInfoList = alarmInfoService.selectAlarmInfoList(alarmInfo);
        return getDataTable(alarmInfoList);
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("alarm:daily:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated AlarmInfo alarmInfo) {
        alarmInfo.setModelStatus(0);
        int res = alarmInfoService.insertAlarmInfo(alarmInfo);
        return toAjax(res);
    }

    @RequiresPermissions("alarm:daily:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int res = alarmInfoService.deleteAlarmInfo(ids);
        return toAjax(res);
    }

}
