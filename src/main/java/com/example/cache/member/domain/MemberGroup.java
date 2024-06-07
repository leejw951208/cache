package com.example.cache.member.domain;

import com.example.cache.group.domain.Group;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public record MemberGroup(long id, String name, int age, LocalDateTime createdDate, Group group) {
}
