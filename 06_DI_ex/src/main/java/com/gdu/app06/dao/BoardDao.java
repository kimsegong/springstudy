package com.gdu.app06.dao;

import java.util.Arrays;
import java.util.List;

import com.gdu.app06.dto.BoardDto;

public class BoardDao {

  private BoardDto boardDto1;
  private BoardDto boardDto2;
  private BoardDto boardDto3;
  
  public List<BoardDto> getBoardList() {
    return Arrays.asList(boardDto1, boardDto2, boardDto3);
  }
  public BoardDto getBoardByNo(int boardNo) {
    BoardDto boardDto = null;
    if(boardDto1.getBoardNo() == boardNo) {
      boardDto = boardDto1;
    } else if(boardDto2.getBoardNo() == boardNo) {
      boardDto = boardDto2;
    } else if(boardDto3.getBoardNo() == boardNo) {
      boardDto = boardDto3;
    }    
    return boardDto;
  }
  
}
