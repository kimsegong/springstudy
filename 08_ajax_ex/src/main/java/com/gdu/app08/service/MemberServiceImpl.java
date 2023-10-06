package com.gdu.app08.service;

import java.io.File;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.gdu.app08.dao.MemberDao;
import com.gdu.app08.dto.MemberDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor  
@Service
public class MemberServiceImpl implements MemberService {

  private final MemberDao memberDao;
  
  @Override
  public Map<String, Object> getBmiInfo(int memberNo) {
 
    MemberDto memberDto = memberDao.getMemberByNo(memberNo);
    
    double bmi = memberDto.getWeight() / ((Math.pow(memberDto.getHeight(), 2)) / 10000);
    String state = null;
    if(bmi < 18) {
      state = "저체중";
    } else if(bmi < 25) {
      state = "정상";
    } else if(bmi < 32) {
      state = "과체중";
    } else {
      state = "비만";
    }
    
    return Map.of("bmi", bmi, "state", state, "name", memberDto.getName());
  }
  @Override
  public byte[] getProfileImage(int memberNo) {
    byte[] b = null;
    try {
      String path = "D:\\GDJ69\\assets\\image";
      String filename= "flower" + memberNo + ".jpg";
      File file = new File(path, filename);
      b = FileCopyUtils.copyToByteArray(file);
    } catch (Exception e) {
     e.printStackTrace();
    }   
    return b;
  }
}
