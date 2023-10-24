package com.gdu.staff.dao;



import org.apache.ibatis.annotations.Mapper;

import com.gdu.staff.dto.StaffDto;

@Mapper
public interface StaffMapper {
  public StaffDto getStaffList();
  public StaffDto getStaff(String staffNo);
  public int insertStaff(StaffDto staffDto);
}
