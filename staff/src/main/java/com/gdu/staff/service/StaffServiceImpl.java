package com.gdu.staff.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.staff.dao.StaffMapper;
import com.gdu.staff.dto.StaffDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

  private final StaffMapper staffMapper;
  
  @Override
  public ResponseEntity<Map<String, Object>> registerStaff(StaffDto staff) {
    int addResult = 0;
    Map<String, Object> map = new HashMap<>();
     try {
       addResult = staffMapper.insertStaff(staff);  
       map.put("addResult", addResult);
       return new ResponseEntity<>(map, HttpStatus.OK);
    } catch (Exception e) {
      map.put("addResult", addResult);
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);    
    }   

  }
  
  
  @Override
  public ResponseEntity<Map<String, Object>> getStaff(String staffNo) {
      Map<String, Object> resultMap = new HashMap<>();
      
      // staffNo를 사용하여 스태프 정보를 데이터베이스에서 가져옵니다.
      StaffDto staff = staffMapper.getStaff(staffNo);
      
      if (staff != null) {
          // 스태프 정보가 있는 경우, 결과를 resultMap에 추가합니다.
          resultMap.put("staff", staff);
          return new ResponseEntity<>(resultMap, HttpStatus.OK);
      } else {
          // 스태프 정보가 없는 경우, 오류 메시지를 반환합니다.
          resultMap.put("error", "Staff not found.");
          return new ResponseEntity<>(resultMap, HttpStatus.NOT_FOUND);
      }
  }
  
}
