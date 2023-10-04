package com.gdu.app05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdu.app05.dao.BoardDao;
import com.gdu.app05.dto.BoardDto;

public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardDao boardDao;
  
  @Override
  public List<BoardDto> getBoardList() {
    return boardDao.getBoardList();
  }

}
