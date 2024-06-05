package com.example.cache;

import com.example.cache.board.dto.BoardSaveDto;
import com.example.cache.board.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BoardTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveBoardTest() throws Exception {
        // given
        BoardSaveDto boardSaveDto = new BoardSaveDto("제목", "내용", "작성자");
        String boardSaveDtoJson = objectMapper.writeValueAsString(boardSaveDto);

        // when
        ResultActions actions = mockMvc.perform(post("/api/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(boardSaveDtoJson))
                .andDo(print());

        // then
        actions.andExpect(status().isCreated())
                .andExpect(content().string(notNullValue()));
    }
}
