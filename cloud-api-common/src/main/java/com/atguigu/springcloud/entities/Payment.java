package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenpeng on 2020/11/2 15:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long id;

    private String serial;
}
