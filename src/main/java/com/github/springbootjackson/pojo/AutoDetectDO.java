package com.github.springbootjackson.pojo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * <p>
 * 创建时间为 10:56 2019-04-09
 * 项目名称 spring-boot-jackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class AutoDetectDO {

    private String name;

    public String pass;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
