package com.example.cache.group.controller;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupTest;
import com.example.cache.group.dto.GroupDto;
import com.example.cache.group.dto.SaveGroupDto;
import com.example.cache.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/api/group")
    public ResponseEntity<String> saveGroup(@RequestBody SaveGroupDto saveGroupDto) {
        groupService.saveGroup(saveGroupDto.groupName());
        return new ResponseEntity<>("succeed", HttpStatus.CREATED);
    }

    @GetMapping("/api/group/{id}")
    public ResponseEntity<GroupDto> findGroup(@PathVariable("id") long groupId) {
        Group findGroup = groupService.findGroup(groupId);
        return new ResponseEntity<>(new GroupDto(findGroup.groupId(), findGroup.groupName(), findGroup.createdDate()), HttpStatus.OK);
    }
}
