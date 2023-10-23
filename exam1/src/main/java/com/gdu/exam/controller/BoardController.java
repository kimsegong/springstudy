package com.gdu.exam.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.exam.dto.BoardDto;
import com.gdu.exam.service.BoardService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class BoardController {
	
   
   private final BoardService boardService;
	
   @GetMapping(value="/board/list.do")
   public String list(Model model) {
	 List<BoardDto> boardList = boardService.getBoardList();
	 model.addAttribute("boardList", boardList);
     return "board/list";
   }
   
   @GetMapping(value="/board/write.do")
   public String write() {
	   return "board/write";
   }
   @PostMapping(value="/board/insert.do")
   public String add(BoardDto boardDto
                    , RedirectAttributes redirectAttributes) {
     int addResult = boardService.addBoard(boardDto);
     redirectAttributes.addFlashAttribute("addResult", addResult);
     return "redirect:/board/list.do";
   }
   @GetMapping(value="/board/detail.do")
   public String detail(@RequestParam int boardNo, Model model) {
     BoardDto boardDto = boardService.getBoard(boardNo);
     model.addAttribute("board", boardDto);
     return "board/detail";  
   }
   @GetMapping("/board/delete.do")
   public String delete(@RequestParam int no, RedirectAttributes redirectAttributes) {
       int deleteResult = boardService.delete(no);
       redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
       return "redirect:/board/list.do";
   }

}
