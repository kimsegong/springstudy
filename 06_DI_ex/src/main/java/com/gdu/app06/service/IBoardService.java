package com.gdu.app06.service;

import java.util.List;

import com.gdu.app06.dto.BoardDto;

public interface IBoardService {
  public List<BoardDto> getBoardList();
  public BoardDto getBoardByNo(int boardNo);
}