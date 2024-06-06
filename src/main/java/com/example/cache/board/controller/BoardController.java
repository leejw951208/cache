package com.example.cache.board.controller;

import com.example.cache.board.domain.BoardSave;
import com.example.cache.board.domain.BoardView;
import com.example.cache.board.domain.BoardViewTest;
import com.example.cache.board.dto.BoardSaveDto;
import com.example.cache.board.dto.BoardViewDto;
import com.example.cache.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseEntity<Long> saveBoard(@RequestBody BoardSaveDto saveDto) {
        BoardSave createdBoardSave = new BoardSave(saveDto.title(), saveDto.post(), saveDto.author());
        return new ResponseEntity<>(boardService.saveBoard(createdBoardSave), HttpStatus.CREATED);
    }

    @GetMapping("/api/board/{id}")
    public ResponseEntity<BoardViewDto> findBoard(@PathVariable("id") long id) {
        BoardView boardView = boardService.findBoard(id);
        BoardViewDto boardViewDto = new BoardViewDto(boardView.boardId(), boardView.title(), boardView.post(), boardView.author(), boardView.postOn());
        return new ResponseEntity<>(boardViewDto, HttpStatus.OK);
    }
}
