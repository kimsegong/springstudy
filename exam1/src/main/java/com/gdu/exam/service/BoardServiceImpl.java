package com.gdu.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.exam.dao.BoardMapper;
import com.gdu.exam.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;
	
	@Override
	public int addBoard(BoardDto boardDto) {
		return boardMapper.addBoard(boardDto);
		}
	@Override
	public List<BoardDto> getBoardList() {
		return boardMapper.getBoardList();
		}
	@Override
	public BoardDto getBoard(int no) {
		 return boardMapper.getBoard(no);
		}
}
