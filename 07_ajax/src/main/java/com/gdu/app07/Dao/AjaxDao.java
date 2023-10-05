package com.gdu.app07.Dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app07.Dto.AjaxDto;

@Repository
public class AjaxDao {

  private AjaxDto a; 
  private AjaxDto b; 
  private AjaxDto c; 
  
  @Autowired
  public void setBean(AjaxDto a, AjaxDto b, AjaxDto c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
  public List<AjaxDto> getDtoList() {
   return Arrays.asList(a, b, c);
  }
  public AjaxDto getDto(int no) {
    AjaxDto dto = null;
    if(no == 1) {
      dto = a;
    } else if (no == 2) {
      dto = b;
    } else if (no == 3) {
      dto = c;
    }
    return dto;
  }
}
