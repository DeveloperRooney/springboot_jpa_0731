package com.springbootjpa.board.controller;

import com.springbootjpa.board.dto.BoardDto;
import com.springbootjpa.board.dto.Paging;
import com.springbootjpa.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model, @RequestParam(value = "page", defaultValue = "1") Integer nowPageNum) {

        model.addAttribute("boardList", boardService.boardList(nowPageNum));
        model.addAttribute("nowPage", nowPageNum);
        model.addAttribute("pageBlock", boardService.getPageBlock(nowPageNum));

        return "/board/boardList";
    }

    @GetMapping("/write")
    public String boardWrite() {
        return "/board/boardWrite";
    }

    @PostMapping("/write")
    public String boardWriteDo(BoardDto dto) {
        boardService.boardWrite(dto);
        return "redirect:/board/list";
    }

    @GetMapping("/view")
    public String boardView(Model model, @RequestParam(name = "id") Integer articleNum) {

        System.out.println(articleNum);
        model.addAttribute("article", boardService.boardView(articleNum));
        return "/board/boardView";
    }

    @GetMapping("/update")
    public String boardUpdate(@RequestParam(name="id") Integer articleNum,
                              @RequestParam(name="title") String title,
                              @RequestParam(name="contents") String contents) {

        BoardDto boardDto = BoardDto.builder()
                .id(articleNum.longValue())
                .title(title)
                .contents(contents).build();

        boardService.articleUpdate(boardDto);

        return "redirect:/board/list";
    }
}