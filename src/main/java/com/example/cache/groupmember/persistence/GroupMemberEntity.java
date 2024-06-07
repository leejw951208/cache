package com.example.cache.groupmember.persistence;

import com.example.cache.group.persistence.GroupEntity;
import com.example.cache.member.persistence.MemberEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_group_member")
@Entity
public class GroupMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity groupEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
