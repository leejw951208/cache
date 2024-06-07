package com.example.cache.member.repository;

import com.example.cache.group.domain.Group;
import com.example.cache.group.mapper.GroupMapper;
import com.example.cache.group.persistence.GroupEntity;
import com.example.cache.member.domain.Member;
import com.example.cache.member.domain.MemberSave;
import com.example.cache.member.mapper.MemberMapper;
import com.example.cache.member.persistence.MemberEntity;
import com.example.cache.member.persistence.MemberEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberEntityRepository memberEntityRepository;
    private final MemberMapper memberMapper;

    @Override
    public long save(MemberSave memberSave) {
        MemberEntity memberEntity = memberMapper.toEntity(memberSave);
        return memberEntityRepository.save(memberEntity).getId();
    }

    @Override
    public Member findById(long memberId) {
        MemberEntity findEntity = memberEntityRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("멤버 정보를 찾을 수 없습니다."));
        return memberMapper.toDomain(findEntity);
    }

    @Override
    public List<Member> findByIds(List<Long> memberIds) {
        List<MemberEntity> findEntities = memberEntityRepository.findByIdIn(memberIds);
        return memberMapper.toDomain(findEntities);
    }
}
