package com.github.springbootjackson.controller;

import com.github.springbootjackson.pojo.InnerClassVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * create in 2022/1/5 3:46 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class InnerClassController {

    @GetMapping("date")
    public InnerClassVO get(){
        return new InnerClassVO();
    }

}
