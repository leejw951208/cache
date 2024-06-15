package com.example.cache.group.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private long id;
    private String name;
    private LocalDateTime createdDate;

    public void updateName(String groupName) {
        this.name = groupName;
    }
}
