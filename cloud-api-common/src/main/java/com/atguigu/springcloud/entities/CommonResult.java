package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenpeng on 2020/11/2 15:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T>{

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
