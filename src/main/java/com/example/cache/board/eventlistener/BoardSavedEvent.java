package com.example.cache.board.eventlistener;

import com.example.cache.board.domain.BoardSave;

public record BoardSavedEvent(Long boardId, BoardSave boardSave) {
}
