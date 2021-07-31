package com.springbootjpa.board.service;

import com.springbootjpa.board.entity.Board;
import com.springbootjpa.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void boardWrite() {

    }
}
