package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.AlarmInfo;
import com.ruoyi.system.mapper.AlarmInfoMapper;
import com.ruoyi.system.service.IAlarmInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlarmInfoServiceImpl implements IAlarmInfoService {

    @Resource
    private AlarmInfoMapper alarmInfoMapper;

    @Override
    public List<AlarmInfo> selectAlarmInfoList(AlarmInfo alarmInfo) {
        return alarmInfoMapper.selectAlarmInfoList(alarmInfo);
    }

    @Override
    public int insertAlarmInfo(AlarmInfo alarmInfo) {
        return alarmInfoMapper.insertAlarmInfo(alarmInfo);
    }

    @Override
    public int deleteAlarmInfo(String infoIds) {
        Long[] infoIdArray = Convert.toLongArray(infoIds);
        return alarmInfoMapper.deleteAlarmInfo(infoIdArray);
    }

    @Override
    public List<AlarmInfo> selectWeatherRiskList(AlarmInfo alarmInfo) {
        return alarmInfoMapper.selectWeatherRiskList(alarmInfo);
    }

    @Override
    public List<AlarmInfo> selectFireRiskList(AlarmInfo alarmInfo) {
        return alarmInfoMapper.selectFireRiskList(alarmInfo);
    }

    @Override
    public List<AlarmInfo> selectFireProofList(AlarmInfo alarmInfo) {
        return alarmInfoMapper.selectFireProofList(alarmInfo);
    }

    @Override
    public List<AlarmInfo> selectFireCommunicationList(AlarmInfo alarmInfo) {
        return alarmInfoMapper.selectFireCommunicationList(alarmInfo);
    }
}
