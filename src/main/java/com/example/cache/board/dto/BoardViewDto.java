package com.example.cache.board.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BoardViewDto(
        long boardId,
        String title,
        String post,
        String author,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime postOn
) {
}
