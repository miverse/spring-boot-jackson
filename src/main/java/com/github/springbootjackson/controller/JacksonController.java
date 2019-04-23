package com.github.springbootjackson.controller;


import com.github.springbootjackson.pojo.JacksonDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 创建时间为 21:42-2019-04-22
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class JacksonController {

    @PostMapping("jackson")
    public JacksonDO postUserDO(@RequestBody JacksonDO userDO) {
        return userDO;
    }

}
