package com.gdu.exam.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
    public BoardDto getBoard(int boardNo) {
        return boardMapper.getBoard(boardNo);
    }

    @Override
    public int delete(int boardNo) {
        return boardMapper.delete(boardNo);
    }

	
}
