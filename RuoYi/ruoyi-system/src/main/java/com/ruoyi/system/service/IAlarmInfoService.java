package com.ruoyi.system.service;

import com.ruoyi.system.domain.AlarmInfo;

import java.util.List;

public interface IAlarmInfoService {

    public List<AlarmInfo> selectAlarmInfoList(AlarmInfo alarmInfo);

    int insertAlarmInfo(AlarmInfo alarmInfo);

    int deleteAlarmInfo(String infoIds);

    List<AlarmInfo> selectWeatherRiskList(AlarmInfo alarmInfo);

    List<AlarmInfo> selectFireRiskList(AlarmInfo alarmInfo);

    List<AlarmInfo> selectFireProofList(AlarmInfo alarmInfo);

    List<AlarmInfo> selectFireCommunicationList(AlarmInfo alarmInfo);
}
