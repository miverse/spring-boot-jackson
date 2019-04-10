package com.github.springbootjackson.pojo;

import com.alibaba.fastjson.JSON;
import com.github.springbootjackson.enums.TimeUnitEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 创建时间为 10:58 2019-04-09
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

    private TimeUnitEnum timeUnit;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
