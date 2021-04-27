package com.github.springbootjackson.controller;

import com.github.springbootjackson.pojo.SerializationDTO;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
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
 * create in 2021/4/27 2:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@DirtiesContext
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SerializationControllerTest {

    @Resource
    private MockMvc mockMvc;

    /**
     * {@link SerializationController#serialize(SerializationDTO)}
     */
    @DisplayName("测试序列化与反序列化")
    @Test
    void deserialize() throws Exception {
        mockMvc.perform(post("/de").content(getData())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test_username"))
                .andExpect(jsonPath("$.mobiles").value("18888888888|18888888889"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @NotNull
    @Contract(pure = true)
    private String getData() {
        return "{\"username\":\"test_username\",\"mobiles\":\"18888888888|18888888889\"}";
    }

}