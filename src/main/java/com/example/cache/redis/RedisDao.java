package com.example.cache.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisDao {
    private final RedisTemplate<String, String> redisTemplate;

    public void setValue(String key, String value) {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value);
    }

    public String getValue(String key) {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        return opsForValue.get(key);
    }
}
