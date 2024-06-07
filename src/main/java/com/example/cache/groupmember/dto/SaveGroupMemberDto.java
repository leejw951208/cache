package com.example.cache.groupmember.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

public record SaveGroupMemberDto(
        String test,
        @JsonProperty(value = "memberIds")
        List<Long> memberIds
) {
}
