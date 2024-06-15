package com.example.cache.group.controller;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupSave;
import com.example.cache.group.dto.GroupDto;
import com.example.cache.group.dto.SaveGroupDto;
import com.example.cache.group.mapper.GroupMapper;
import com.example.cache.group.service.GroupService;
import com.example.cache.groupmember.dto.SaveGroupMemberDto;
import com.example.cache.groupmember.service.GroupMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final GroupMemberService groupMemberService;
    private final GroupMapper groupMapper;

    @PostMapping("/api/group")
    public ResponseEntity<Long> saveGroup(@RequestBody SaveGroupDto saveGroupDto) {
        GroupSave groupSave = groupMapper.toDomain(saveGroupDto);
        return new ResponseEntity<>(groupService.saveGroup(groupSave), HttpStatus.CREATED);
    }

    @PutMapping("/api/group/{id}")
    public ResponseEntity<Long> updateGroup(@PathVariable long id, @RequestBody SaveGroupDto saveGroupDto) {
        GroupSave groupSave = groupMapper.toDomain(saveGroupDto);
        return new ResponseEntity<>(groupService.updateGroup(id, groupSave), HttpStatus.CREATED);
    }

    @GetMapping("/api/group/{id}")
    public ResponseEntity<GroupDto> findGroup(@PathVariable("id") long groupId) {
        Group findGroup = groupService.findGroup(groupId);
        return new ResponseEntity<>(groupMapper.toDto(findGroup), HttpStatus.OK);
    }

    @PostMapping("/api/group/{id}/members")
    public ResponseEntity<String> saveGroupMember(@PathVariable("id") long groupId, @RequestBody SaveGroupMemberDto saveGroupMemberDto) {
        List<Long> memberIds = saveGroupMemberDto.memberIds();
        groupMemberService.saveGroupMember(groupId, memberIds);
        return new ResponseEntity<>("succeed", HttpStatus.CREATED);
    }
}
