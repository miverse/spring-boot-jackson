package com.github.springbootjackson.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.springbootjackson.pojo.deserialize.MobileDeserializer;
import com.github.springbootjackson.pojo.serialize.MobileSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * @author 石少东
 * @date 2020-10-23 15:18
 * @since 1.0
 */

@Getter
@Setter
@ToString
public class SerializationDTO {

    private String username;

    @JsonSerialize(using = MobileSerializer.class)
    @JsonDeserialize(using = MobileDeserializer.class)
    private Set<String> mobiles;

}
