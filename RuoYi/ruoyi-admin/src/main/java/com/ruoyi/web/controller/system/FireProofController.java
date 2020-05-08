package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.AlarmInfo;
import com.ruoyi.system.service.IAlarmInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/fire/proof")
public class FireProofController extends BaseController
{
    private String prefix = "fire/proof";

    @Resource
    private IAlarmInfoService alarmInfoService;

    @RequiresPermissions("fire:proof:view")
    @GetMapping()
    public String proof()
    {
        return prefix + "/proof";
    }

    @RequiresPermissions("fire:proof:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AlarmInfo alarmInfo) {
        startPage();
        List<AlarmInfo> fireProofList = alarmInfoService.selectFireProofList(alarmInfo);
        return getDataTable(fireProofList);
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("fire:proof:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated AlarmInfo alarmInfo) {
        alarmInfo.setModelStatus(3);
        int res = alarmInfoService.insertAlarmInfo(alarmInfo);
        return toAjax(res);
    }

    @RequiresPermissions("fire:proof:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int res = alarmInfoService.deleteAlarmInfo(ids);
        return toAjax(res);
    }

}
