package com.github.springbootjackson.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO
 * <p>
 * create in 2021/4/27 2:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DirtiesContext
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JsonViewControllerTest {

    @Resource
    private MockMvc mockMvc;

    @DisplayName("测试简单视图")
    @Test
    void getSimple() throws Exception {
        mockMvc.perform(get("/simple"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.simple").value("Message:Simple"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @DisplayName("测试复杂视图")
    @Test
    void getDetail() throws Exception {
        mockMvc.perform(get("/detail"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.simple").value("Message:Simple"))
                .andExpect(jsonPath("$.detail").value("Message:Detail"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}