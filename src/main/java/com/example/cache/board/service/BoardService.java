package com.example.cache.board.service;

import com.example.cache.board.domain.BoardSave;
import com.example.cache.board.domain.BoardView;
import com.example.cache.board.entity.BoardEntity;
import com.example.cache.board.eventlistener.BoardSavedEvent;
import com.example.cache.board.repository.BoardEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardEntityJpaRepository boardEntityJpaRepository;
    private final ApplicationEventPublisher publisher;

    private static final String BOARD = "board";

    @Transactional
    public Long saveBoard(BoardSave boardSave) {
        BoardEntity createdEntity = BoardEntity.builder()
                .title(boardSave.title())
                .post(boardSave.post())
                .author(boardSave.author())
                .build();

        Long savedId = boardEntityJpaRepository.save(createdEntity).getId();
//        publisher.publishEvent(new BoardSavedEvent(savedId, boardSave));

        return savedId;
    }

    @Cacheable(cacheNames = BOARD, key = "#id", condition = "#id != null", cacheManager = "cacheManager")
    public BoardView findBoard(long id) {
        BoardEntity findEntity = boardEntityJpaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시글을 찾을 수 없습니다."));
        return new BoardView(findEntity.getId(), findEntity.getTitle(), findEntity.getPost(), findEntity.getAuthor(), findEntity.getPostedOn());
    }
}
