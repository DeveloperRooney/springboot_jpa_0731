package com.springbootjpa.board.dto;

import com.springbootjpa.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private Long id;

    private String author;

    private LocalDateTime regDate;

    private LocalDateTime updateDate;

    private String title;

    private String contents;

    public Board toEntity() {
        Board board = Board.builder()
                .id(id)
                .author(author)
                .regDate(regDate)
                .updateDate(updateDate)
                .title(title)
                .contents(contents)
                .build();

        return board;
    }
}
