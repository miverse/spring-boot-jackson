package com.github.springbootjackson.pojo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.springbootjackson.view.UserDetailView;
import com.github.springbootjackson.view.UserSimpleView;
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
public class JsonViewDO {

    @JsonView(UserSimpleView.class)
    private String simple;

    @JsonView(UserDetailView.class)
    private String detail;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
