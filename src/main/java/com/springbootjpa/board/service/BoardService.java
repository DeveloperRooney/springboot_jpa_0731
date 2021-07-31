package com.springbootjpa.board.service;

import com.springbootjpa.board.dto.BoardDto;
import com.springbootjpa.board.entity.Board;
import com.springbootjpa.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private static final int ArticleCount = 10;

    private static final int PageBlock = 10;

    @Autowired
    private BoardRepository boardRepository;


    public List<BoardDto> boardList(Integer pageNum) {

        Page<Board> page = boardRepository.findAll(PageRequest.of(pageNum - 1, ArticleCount,
                Sort.by(Sort.Direction.DESC, "id")));

        List<Board> boardEntityList = page.getContent();

        List<BoardDto> boardList = new ArrayList<>();

        for (Board board : boardEntityList) {
            boardList.add(board.toDto());
        }

        return boardList;
    }

    public void boardWrite(BoardDto dto) {

        dto.setRegDate(LocalDateTime.now());
        Board boardEntity = dto.toEntity();

        boardRepository.save(boardEntity);

    }
}
