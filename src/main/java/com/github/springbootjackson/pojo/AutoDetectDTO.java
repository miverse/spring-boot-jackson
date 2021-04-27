package com.github.springbootjackson.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * <p>
 * 创建时间为 21:56 2019-04-22
 * 项目名称 spring-boot-jackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class AutoDetectDTO {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private String name;

    public String pass;

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public String toString() {
        return MAPPER.writeValueAsString(this);
    }

}
