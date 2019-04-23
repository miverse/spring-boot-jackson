package com.github.springbootjackson.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.springbootjackson.pojo.JsonUnwrapDO;
import com.github.springbootjackson.view.UserDetailView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 21:59-2019-04-22
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class JsonUnwrapController {

    @GetMapping("unwrap1")
    public JsonUnwrapDO getJsonUnwrapResult1() {
        return getJsonUnwrapDO();
    }


    @GetMapping("unwrap2")
    @JsonView(UserDetailView.class)
    public JsonUnwrapDO getJsonUnwrapResult2() {
        return getJsonUnwrapDO();
    }


    private JsonUnwrapDO getJsonUnwrapDO() {
        JsonUnwrapDO jsonUnwrapDO = new JsonUnwrapDO();
        jsonUnwrapDO.setDesc("desc:JsonUnwrapDO");
        JsonUnwrapDO.InnerClassDO innerClassDO = new JsonUnwrapDO.InnerClassDO();
        innerClassDO.setField1("setField1");
        innerClassDO.setField2("setField2");
        jsonUnwrapDO.setInnerClassDO(innerClassDO);
        return jsonUnwrapDO;
    }

}