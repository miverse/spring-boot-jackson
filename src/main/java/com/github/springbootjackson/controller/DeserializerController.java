package com.github.springbootjackson.controller;

import com.github.springbootjackson.pojo.DeserializeDO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-10-23 15:18
 * @since 1.0
 */


@RestController
public class DeserializerController {

    @PostMapping("de")
    public DeserializeDO deserialize(@RequestBody DeserializeDO deserialize) {
        return deserialize;
    }

}
