package com.github.springbootjackson.pojo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 创建时间为 21:57 2019-04-22
 * 项目名称 spring-boot-jackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
public class JsonPropertyDO {

    /**
     * 可以设置访问
     * access = JsonProperty.Access.READ_ONLY
     * access = JsonProperty.Access.READ_WRITE
     */
    @JsonProperty(value = "subName", required = false, index = 1, defaultValue = "123", access = JsonProperty.Access.READ_WRITE)
    private String name;

    @JsonInclude
    private String note;

    /**
     * 为反序列化期间要接受的属性定义一个或多个替代名称
     */
    @JsonIgnore
    @JsonAlias({"pass1", "pass2"})
    private String pass;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
