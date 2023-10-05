package com.gdu.app06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdu.app06.dao.BoardDao;
import com.gdu.app06.dto.BoardDto;


public class BoardServiceImpl implements IBoardService {

  private BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  @Override
  public BoardDto getBoardByNo(int boardNo) {
    return boardDao.getBoardByNo(boardNo);    
  }
  @Override
  public List<BoardDto> getBoardList() {
    return boardDao.getBoardList();    
  }
}
