package com.github.springbootjackson.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.springbootjackson.pojo.JsonViewDO;
import com.github.springbootjackson.view.UserDetailView;
import com.github.springbootjackson.view.UserSimpleView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 21:54-2019-04-22
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class JsonViewController {

    @GetMapping("simple")
    @JsonView(UserSimpleView.class)
    public JsonViewDO getSimple() {
        return getJsonViewDO();
    }

    @GetMapping("detail")
    @JsonView(UserDetailView.class)
    public JsonViewDO getDetail() {
        return getJsonViewDO();
    }

    private JsonViewDO getJsonViewDO() {
        JsonViewDO jsonViewDO = new JsonViewDO();
        jsonViewDO.setSimple("Message:Simple");
        jsonViewDO.setDetail("Message:Detail");
        return jsonViewDO;
    }

}
