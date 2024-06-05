package com.example.cache.board.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public record BoardView(
        long boardId,
        String title,
        String post,
        String author,
        LocalDateTime postedOn
) {
}
