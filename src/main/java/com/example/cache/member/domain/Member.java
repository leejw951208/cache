package com.example.cache.member.domain;

import java.time.LocalDateTime;

public record Member(long id, String name, int age, LocalDateTime createdDate) {
}
