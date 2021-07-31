package com.springbootjpa.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("name", "suhan");

        return "/board/boardList";
    }
}