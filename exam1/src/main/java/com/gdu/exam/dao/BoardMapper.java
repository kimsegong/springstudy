package com.gdu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.exam.dto.BoardDto;

@Mapper
public interface BoardMapper {
    public BoardDto getBoard(int boardNo);
	public int addBoard(BoardDto boardDto);
	public List<BoardDto> getBoardList();
	public int delete(int boardNo);

}
