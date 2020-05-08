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
@RequestMapping("/fire/communication")
public class FireCommunicationController extends BaseController
{
    private String prefix = "fire/communication";

    @Resource
    private IAlarmInfoService alarmInfoService;

    @RequiresPermissions("fire:communication:view")
    @GetMapping()
    public String communication()
    {
        return prefix + "/communication";
    }

    @RequiresPermissions("fire:communication:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AlarmInfo alarmInfo) {
        startPage();
        List<AlarmInfo> fireCommunicationList = alarmInfoService.selectFireCommunicationList(alarmInfo);
        return getDataTable(fireCommunicationList);
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("fire:communication:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated AlarmInfo alarmInfo) {
        alarmInfo.setModelStatus(4);
        int res = alarmInfoService.insertAlarmInfo(alarmInfo);
        return toAjax(res);
    }

    @RequiresPermissions("fire:communication:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int res = alarmInfoService.deleteAlarmInfo(ids);
        return toAjax(res);
    }

}
