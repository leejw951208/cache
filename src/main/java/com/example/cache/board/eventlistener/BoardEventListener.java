package com.example.cache.board.eventlistener;

import com.example.cache.board.domain.BoardSave;
import com.example.cache.redis.RedisDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class BoardEventListener {
    private final RedisDao redisDao;
    private final ObjectMapper objectMapper;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveCache(BoardSavedEvent event) throws Exception {
        throw new IllegalArgumentException("예외 발생");
//        String boardId = String.valueOf(event.boardId());
//        BoardSave boardSave = event.boardSave();
//        String boardSaveJson = objectMapper.writeValueAsString(boardSave);
//        redisDao.setValue(boardId, boardSaveJson);
    }
}
