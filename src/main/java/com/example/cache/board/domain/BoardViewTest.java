package com.example.cache.board.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class BoardViewTest {
    private long boardId;
    private String title;
    private String post;
    private String author;
    private LocalDateTime postOn;
}
