package com.springbootjpa.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Paging {

    // 한 페이지에 보여줄 게시물 수
    private Integer onePageArticleCount = 10;

    // 한 페이지에 보여줄 페이지 수
    private Integer onePageBlock = 10;

    // 총 게시물 수
    private Integer articleCount;

    //현재 페이지
    private Integer nowPage;

    // 총 페이지 수
    private Integer totalPage;

    // 시작 페이지
    private Integer startPage;

    // 마지막 페이지
    private Integer endPage;

    public Paging(Integer articleCount, Integer nowPage) {
        this.articleCount = articleCount;
        this.nowPage = nowPage;

        if ((articleCount/10) != 0) {
            this.totalPage = articleCount/onePageArticleCount + 1;
        }else {
            this.totalPage = articleCount/onePageArticleCount;
        }

        if (nowPage < 5) {
            this.startPage = 1;
            this.endPage = 10;
        }else {
            this.startPage = nowPage - 4;
            if(nowPage + 5 > totalPage) {
                endPage = totalPage;
                this.startPage = totalPage - 9;
            }else {
                this.endPage = nowPage + 5;
            }

        }
    }
}
