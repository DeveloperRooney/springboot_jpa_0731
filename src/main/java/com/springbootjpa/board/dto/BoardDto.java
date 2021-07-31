package com.springbootjpa.board.dto;

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
}
