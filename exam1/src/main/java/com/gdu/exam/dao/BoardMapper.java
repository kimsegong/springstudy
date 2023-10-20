package com.gdu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.exam.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public List<BoardDto> getBoardList();
    public BoardDto getBoard(int no);
	public int addBoard(BoardDto boardDto);
}
