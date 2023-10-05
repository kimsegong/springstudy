package com.gdu.app07.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.app07.Dao.AjaxDao;
import com.gdu.app07.Dto.AjaxDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AjaxServiceImpl implements AjaxService {
 
  private final AjaxDao ajaxDao;
  
  @Override
  public List<AjaxDto> getDtoList() {
    return ajaxDao.getDtoList();
  }

  @Override
  public AjaxDto getDto(String name) {
    int no = 0;
    if(name.equals("뽀로로")) {
      no = 1;
    } else if(name.equals("루피")) {
      no = 2;
    } else if(name.equals("크롱")) {
      no = 3;
    }
    return ajaxDao.getDto(no);
  }

}
