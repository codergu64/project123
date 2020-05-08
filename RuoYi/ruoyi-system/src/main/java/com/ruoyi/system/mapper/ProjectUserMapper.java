package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ProjectUser;

import java.util.List;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
public interface ProjectUserMapper
{

    public ProjectUser selectUserByLoginName(String loginName);

    List<ProjectUser> selectProjectUserList(ProjectUser user);

    ProjectUser checkPhoneUnique(Long mobileNumber);

    ProjectUser checkEmailUnique(String email);

    int insertUser(ProjectUser user);

    int updateUser(ProjectUser user);

    ProjectUser selectUserByPhoneNumber(String phoneNumber);

    ProjectUser selectUserByEmail(String email);

    int checkLoginNameUnique(String loginName);

    ProjectUser selectUserById(Long userId);

    int deleteUserByIds(Long[] userIds);
}
