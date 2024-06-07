package com.example.cache.groupmember.eventlistener;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class CacheEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @CacheEvict(cacheNames = "member", key = "#event.memberIds()")
    public void cacheEvict(MemberCacheEvict event) {
    }
}
