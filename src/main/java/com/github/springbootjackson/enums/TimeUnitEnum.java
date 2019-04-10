package com.github.springbootjackson.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sun.tools.javac.util.StringUtils;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@SuppressWarnings("unused")
public enum TimeUnitEnum {


    /**
     * 秒
     */

    SECOND("SECOND", TimeUnit.SECONDS),

    /**
     * 分钟
     */
    @JsonEnumDefaultValue
    MINUTES("MINUTES", TimeUnit.MINUTES),

    /**
     * 小时
     */
    HOURS("HOURS", TimeUnit.HOURS),

    /**
     * 天
     */
    DAYS("DAYS", TimeUnit.DAYS);

    private static Map<String, TimeUnit> timeUnitMap = Stream.of(TimeUnitEnum.values())
            .collect(Collectors.toMap(one -> one.unit, TimeUnitEnum::getTimeUnit));

    @Getter
    @JsonValue
    private String unit;

    @Getter
    private TimeUnit timeUnit;

    TimeUnitEnum(String unit, TimeUnit timeUnit) {
        this.unit = unit;
        this.timeUnit = timeUnit;
    }

    /**
     *
     * @param value value
     * @return TimeUnit
     */
    @JsonCreator
    public static TimeUnit forValue(String value) {
        return Optional.ofNullable(timeUnitMap.get(StringUtils.toUpperCase(value))).orElseThrow(() -> new IllegalArgumentException(value));
    }

}
