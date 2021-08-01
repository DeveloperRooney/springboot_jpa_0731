package com.springbootjpa.board.service;

import com.springbootjpa.board.dto.BoardDto;
import com.springbootjpa.board.dto.Paging;
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
import java.util.Optional;

@Service
public class BoardService {

    private static final int ArticleCount = 10; // 한 페이지에 존재하는 게시글 수

    private static final int PageBlock = 10; // 페이지 블럭에 존재하는 페이지 수

    @Autowired
    private BoardRepository boardRepository;


    public List<BoardDto> boardList(Integer pageNum) {

        Page<Board> page = boardRepository.findAll(PageRequest.of(pageNum - 1, PageBlock,
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

    public BoardDto boardView(Integer articleNum) {

        Long article = articleNum.longValue();


        Board articleEntity = boardRepository.findById(article).get();

        BoardDto boardDto = articleEntity.toDto();

        return boardDto;

    }


    public void getPageInfo(Integer nowPageNum) {

        // 현재 페이지
        Integer nowPage = nowPageNum;

        // 총 게시글 수
        Long articleTotalCount = boardRepository.count();

        // 총 페이지 수
        Integer totalPage = null;

        if((articleTotalCount / 10) != 0) {
            totalPage = articleTotalCount.intValue()/ArticleCount + 1;
        }else {
            totalPage = articleTotalCount.intValue()/ArticleCount;
        }


    }

    public Integer getArticleCount() {

        Long articleCount = boardRepository.count();

        return articleCount.intValue();
    }

    public List<Integer> getPageBlock(Integer nowPageNum) {

        Paging paging = new Paging(getArticleCount(), nowPageNum);

        List<Integer> pageBlock = new ArrayList<>();
        for (int x = paging.getStartPage(); x <= paging.getEndPage(); x++) {
            pageBlock.add(new Integer(x));
        }

        return pageBlock;

    }
}
