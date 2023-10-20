package com.gdu.exam.service;

import java.util.List;

import com.gdu.exam.dto.BoardDto;

public interface BoardService {
	
	public BoardDto getBoard(int no);
    public int addBoard(BoardDto boardDto);
    public List<BoardDto> getBoardList();
}
