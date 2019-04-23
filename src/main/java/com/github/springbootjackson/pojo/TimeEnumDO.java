package com.github.springbootjackson.pojo;

import com.alibaba.fastjson.JSON;
import com.github.springbootjackson.enums.TimeUnitEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 创建时间为 21:58 2019-04-22
 * 项目名称 spring-boot-jackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
public class TimeEnumDO {

    private String desc;

    private TimeUnit timeUnit;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
