package com.springbootjpa.board.controller;

import com.springbootjpa.board.dto.BoardDto;
import com.springbootjpa.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model) {

        return "/board/boardList";
    }

    @GetMapping("/write")
    public String boardWrite() {

        return "/board/boardWrite";
    }

    @PostMapping("/write")
    public String boardWriteDo(BoardDto dto) {


        return "redirect:/board/list";
    }
}