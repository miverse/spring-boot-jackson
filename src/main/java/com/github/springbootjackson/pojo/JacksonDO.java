package com.github.springbootjackson.pojo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

/**
 * 表示对于pass字段，反序列化和序列化均忽略，而对于Json中存在的未知字段，在反序列化时忽略，ignoreUnknown不对序列化起效。
 * 如果要调用第三方的API，可以使用通过@JsonIgnoreProperties(ignoreUnknown = true)忽略掉所有不需要的字段。
 * 用来修饰类
 * JsonIgnoreProperties(value = {"pass"}, ignoreUnknown = true)
 * 修饰类，忽略指定的类型的字段
 * JsonIgnoreType()
 *
 * 序列化时排除null或者空字符串
 * JsonInclude(JsonInclude.Include.NON_NULL)
 *
 * 表示在序列化Person时，将值为null的字段排除掉。
 * JsonInclude(JsonInclude.Include.NON_EMPTY)
 * JsonRootName("JacksonDO")
 *
 * 作用在类上，被用来指明当序列化时需要对属性做排序，它有2个属性
 * 一个是alphabetic：布尔类型，表示是否采用字母拼音顺序排序，默认是为false，即不排序
 *
 *
 * <p>
 * 创建时间为 14:45-2019-03-22
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@JsonPropertyOrder(alphabetic = true, value = {"date", "age"})
public class JacksonDO {

    /**
     * 为这个字段添加别名,指定顺序,默认值
     */
    @JsonProperty(value = "first_name", required = true, index = 3, defaultValue = "nnn")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pass;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date date;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
