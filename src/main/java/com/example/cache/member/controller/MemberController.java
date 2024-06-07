package com.example.cache.member.controller;

import com.example.cache.member.domain.MemberGroup;
import com.example.cache.member.domain.MemberSave;
import com.example.cache.member.dto.MemberGroupDto;
import com.example.cache.member.dto.SaveMemberDto;
import com.example.cache.member.mapper.MemberMapper;
import com.example.cache.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @PostMapping("/api/member")
    public ResponseEntity<Long> saveMember(@RequestBody SaveMemberDto saveMemberDto) {
        MemberSave memberSave = memberMapper.toDomain(saveMemberDto);
        return new ResponseEntity<>(memberService.saveMember(memberSave), HttpStatus.CREATED);
    }

    @GetMapping("/api/member/{id}")
    public ResponseEntity<MemberGroupDto> findMember(@PathVariable("id") long memberId) {
        MemberGroup findMemberGroup = memberService.findMember(memberId);
        MemberGroupDto dto = memberMapper.toDto(findMemberGroup);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
