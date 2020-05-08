package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.AlarmInfo;

import java.util.List;

public interface AlarmInfoMapper {

    List<AlarmInfo> selectAlarmInfoList(AlarmInfo alarmInfo);

    int insertAlarmInfo(AlarmInfo alarmInfo);

    int deleteAlarmInfo(Long[] infoIdArray);

    List<AlarmInfo> selectWeatherRiskList(AlarmInfo alarmInfo);

    List<AlarmInfo> selectFireRiskList(AlarmInfo alarmInfo);

    List<AlarmInfo> selectFireProofList(AlarmInfo alarmInfo);

    List<AlarmInfo> selectFireCommunicationList(AlarmInfo alarmInfo);
}
