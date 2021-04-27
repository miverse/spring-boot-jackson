package com.github.springbootjackson.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO
 * <p>
 * create in 2021/4/27 2:43 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DirtiesContext
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JsonPropertyControllerTest {

    @Resource
    private MockMvc mockMvc;

    @DisplayName("测试别名")
    @Test
    void getJsonProperty() throws Exception {
        mockMvc.perform(post("/property").content(getData())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.subName").value("test_name"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private String getData() {
        return "{\"subName\": \"test_name\",\"note\": \"test message\",\"pass1\": \"sssss\"}";
    }

}