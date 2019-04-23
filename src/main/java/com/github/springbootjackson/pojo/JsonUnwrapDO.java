package com.github.springbootjackson.pojo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.springbootjackson.view.UserDetailView;
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
public class JsonUnwrapDO {

    @JsonView(UserDetailView.class)
    private String desc;

    /**
     * 只作用于序列化,会将里面所有的元素展开
     */
    @JsonView(UserDetailView.class)
    @JsonUnwrapped(prefix = "pre_", suffix = "_suf", enabled = true)
    private InnerClassDO innerClassDO;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Getter
    @Setter
    public static class InnerClassDO {

        @JsonView(UserDetailView.class)
        private String field1;

        private String field2;

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

}
