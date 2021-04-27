https://github.com/FasterXML/jackson-annotations/wiki/Jackson-Annotations
https://github.com/FasterXML/jackson-databind/wiki/Databind-Annotations

* 忽略一些字段
* 字段设置别名
* 不同接口展示一个实体来的不同字段;
* 实体类字段设置别名;
* 接口接收枚举类;
* 接口返回只显示非空字段

# 一.前言

Jackson是解析 JSON 数据的工具包，Spring 中默认的 JSON 解析包就是 Jackson。 阿里巴巴的 FastJson 号称是最快的 JSON 解析工具包，但是 Jackson 使用姿势比较丰富，在接口中解析 Body
中数据最好还是用 Jackson。 当然，Jackson 不仅仅可以在 Spring 接口中用，普通的 Java 代码也可以，本文只要讨论在接口中的常用方法。

# 二.基本使用

1.忽略一些字段 使用场景：有些实体类会实现 Serializable 接口生成 static final long serialVersionUID 字段，但是我们并不想在 JSON
字符串中包含这个字段返回，这个字段对于用户来说是无意义的。 只要在不想序列化的字段上使用@JsonIgnore注解

```
@JsonIgnore
private static final long serialVersionUID = 5231134212346077681L; 
```

2.其他忽略字段方法 使用场景：(同1)除了1中的忽略一些字段方法，还可以再 class 上面(修饰类)注解 @JsonIgnoreProperties(value = {"pass"}) 要忽略的字段，这里是 pass
字段内容不参与序列化

3.给字段设置一个别名 使用场景：很多公司 CheckStyle 都采用驼峰格式的，但是调用接口传入的参数是下划线格式的

```
    // 为这个字段添加别名,指定顺序,默认值
    @JsonProperty(value = "first_name", required = true")
    private String name;
```

4.为字段设置很多别名 使用场景：同3

```
    // 为反序列化期间要接受的属性定义一个或多个替代名称
    @JsonAlias({"pass1", "pass2"})
    private String pass;

```

5.反序列化时将字段打平 使用场景：反序列化时会将UserVO中每个字段取出并加上前后缀输出

```
    // 只作用于序列化,会将里面所有的元素展开
    @JsonUnwrapped(prefix = "pre", suffix = "suf", enabled = true)
    private UserVO userVO;
```

UserVO实体类

```
@Data
public class UserVO {
    @JsonView({UserVOSimpleView.class, UserVODetailView.class})
    private String field1 = "11";
    @JsonView(UserVODetailView.class)
    private String field2 = "22";
}
```

6.将时间字符串转换成 Date 类型 使用场景：前后端设计到传时间，很多时候传的是字符串格式，可以直接用@JsonFormat并定义好 pattern，只要是按照pattern传入均可转换。

```
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date date;
```

注：前后端设计到传时间使用字符串并不是最好的方式，时间可以直接传精确到毫秒的时间戳，后端直接用 Date 类型去接受，可以直接将时间戳 转换成Date类型。好像Spring 接口传时间默认就是时间戳的格式。

7.返回不同的 JSON 视图 使用场景：预先定义好一些实体类作为返回的 JSON 字符串，但是不同的接口都用到了这个实体类，我们想不同的接口返回不同的字段。 首先定义一些接口，

```
public interface UserVOSimpleView {
}
```

用来标记需要展示的视图字段

```
    @JsonView(UserVOSimpleView.class)
    private String message = "success";

    @JsonView(UserVOSimpleView.class)
    private int status = SUCCESS;

    @JsonView(UserVOSimpleView.class)
    private T data;

```

最后在返回的 Controller 方法上使用 @JsonView(UserVOSimpleView.class)括号里面是需要返回的视图

```
    @GetMapping("simple")
    @JsonView(UserVOSimpleView.class)
    public ResultBean<UserVO> getUserSimpleVO() {
        return createUserVO();
    }

```

8.传入枚举类型 使用场景：很多时候某些字段是有个固定范围，比如说颜色类型，这时候传入的参数实际上是个枚举类型，如果是简单类型的话可以使用自定义注解去校验，但是如果是复杂类型呢(比如
java.util.concurrent.TimeUnit)，这个时候就不方便去直接传入参数。 首先定义好这个枚举类型的实体类：

```

@SuppressWarnings("unused")
public enum TimeUnitEnum {

    MILLISECONDS("MILLISECONDS", TimeUnit.MILLISECONDS),
    milliseconds("milliseconds", TimeUnit.MILLISECONDS),
    SECOND("SECOND", TimeUnit.SECONDS),
    second("second", TimeUnit.SECONDS),
    MINUTES("MINUTES", TimeUnit.MINUTES),
    minutes("minutes", TimeUnit.MINUTES),
    HOURS("HOURS", TimeUnit.HOURS),
    hours("hours", TimeUnit.HOURS),
    DAYS("DAYS", TimeUnit.DAYS),
    days("days", TimeUnit.DAYS);

    private static Map<String, TimeUnit> timeUnitMap = Stream.of(TimeUnitEnum.values()).collect(Collectors.toMap(one -> one.unit, TimeUnitEnum::getTimeUnit));

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
     * @param value
     * @return
     */
    @JsonCreator
    public static TimeUnit forValue(String value) {
        return Optional.ofNullable(timeUnitMap.get(StringUtils.toUpperCase(value))).orElseThrow(() -> new IllegalArgumentException(value));
    }
}

```

接口转换的实体类

```

@Data
public class UserPO {
    @JsonIgnore
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private String name;
    @NotNull
    private TimeUnitEnum timeEnum;
    @Override
    public String toString() {
        try {
            return MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }
}

```

Controller 接口

```
    @PostMapping("/userpo")
    public UserPO postUserPO(@RequestBody @Valid UserPO userPO) throws Exception{
        log.info(userPO.toString());
        TimeUnitEnum.forValue(userPO.getTimeEnum().getUnit()).sleep(1);
        return userPO;
    }
```



