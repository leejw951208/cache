package com.example.cache.group;

import com.example.cache.group.domain.GroupSave;
import com.example.cache.group.dto.SaveGroupDto;
import com.example.cache.group.mapper.GroupMapper;
import com.example.cache.group.repository.GroupRepository;
import com.example.cache.group.service.GroupService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class GroupServiceTest {
    @Mock
    private GroupRepository groupRepository;

    @Mock
    private GroupMapper groupMapper;

    @InjectMocks
    private GroupService groupService;

    @Test
    public void save() {
        // given
        String groupName = "그룹1";
        GroupSave groupSave = new GroupSave(groupName);

        given(groupRepository.save(groupSave)).willReturn(1L);

        // when
        long savedId = groupService.saveGroup(groupSave);

        // then
        assertEquals(savedId, 1L);
    }
}
