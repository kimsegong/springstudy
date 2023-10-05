package com.gdu.app07.Service;

import java.util.List;

import com.gdu.app07.Dto.AjaxDto;

public interface AjaxService {
  public List<AjaxDto> getDtoList();
  public AjaxDto getDto(String name);
}
