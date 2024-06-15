package com.example.cache.member.domain;

import com.example.cache.group.domain.Group;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberGroup {
    private long id;
    private String name;
    private int age;
    private LocalDateTime createdDate;
    private Group group;
}
