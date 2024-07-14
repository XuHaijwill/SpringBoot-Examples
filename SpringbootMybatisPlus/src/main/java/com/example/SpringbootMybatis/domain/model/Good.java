package com.example.SpringbootMybatis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Good
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/11 8:54
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private String name;
    private String price;
    private String color;
    private String time;
}