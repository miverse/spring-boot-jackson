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
 * create in 2021/4/27 2:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DirtiesContext
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JsonUnwrapControllerTest {

    @Resource
    private MockMvc mockMvc;

    @DisplayName("测试数据展开")
    @Test
    void getJsonUnwrapResult1() throws Exception {
        mockMvc.perform(get("/unwrap1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.desc").value("desc:JsonUnwrapDO"))
                .andExpect(jsonPath("$.pre_field1_suf").value("setField1"))
                .andExpect(jsonPath("$.pre_field2_suf").value("setField2"))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    @DisplayName("测试数据展开")
    @Test
    void getJsonUnwrapResult2() throws Exception {
        mockMvc.perform(get("/unwrap2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.desc").value("desc:JsonUnwrapDO"))
                .andExpect(jsonPath("$.pre_field1_suf").value("setField1"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}