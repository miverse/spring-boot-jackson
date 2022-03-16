package com.github.springbootjackson.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * create in 2022/1/5 3:47 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class InnerClassVO {


    @JsonFormat(pattern = "yyyy-MM")
    private List<LocalDateTime> dateTimes;

    public InnerClassVO() {
        ArrayList<LocalDateTime> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(LocalDateTime.now());
        }
        dateTimes = objects;
    }
}
