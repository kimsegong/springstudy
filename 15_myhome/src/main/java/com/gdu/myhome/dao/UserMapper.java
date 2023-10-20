package com.gdu.myhome.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.myhome.dto.InactiveUserDto;
import com.gdu.myhome.dto.LeaveUserDto;
import com.gdu.myhome.dto.UserDto;

@Mapper
public interface UserMapper {
  public UserDto getUser(Map<String, Object> map);
  public int insertAccess(String email);
  public LeaveUserDto getLeaveUser(Map<String, Object> map);
  public InactiveUserDto getInactiveUser(Map<String, Object> map);
}