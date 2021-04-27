package com.github.springbootjackson.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.springbootjackson.pojo.JsonUnwrapDTO;
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
    public JsonUnwrapDTO getJsonUnwrapResult1() {
        JsonUnwrapDTO unwrapDO = getJsonUnwrapDO();
        log.info("返回数据:{}", unwrapDO);
        return unwrapDO;
    }

    @GetMapping("unwrap2")
    @JsonView(UserDetailView.class)
    public JsonUnwrapDTO getJsonUnwrapResult2() {
        JsonUnwrapDTO unwrapDO = getJsonUnwrapDO();
        log.info("返回数据:{}", unwrapDO);
        return unwrapDO;
    }

    private JsonUnwrapDTO getJsonUnwrapDO() {
        JsonUnwrapDTO jsonUnwrapDTO = new JsonUnwrapDTO();
        jsonUnwrapDTO.setDesc("desc:JsonUnwrapDO");
        JsonUnwrapDTO.InnerClassDO innerClassDO = new JsonUnwrapDTO.InnerClassDO();
        innerClassDO.setField1("setField1");
        innerClassDO.setField2("setField2");
        jsonUnwrapDTO.setInnerClassDO(innerClassDO);
        return jsonUnwrapDTO;
    }

}