package com.example.cache.board.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public record BoardView(
        long boardId,
        String title,
        String post,
        String author,
        LocalDateTime postOn
) {
}
