package com.atguigu.test;

import java.time.ZonedDateTime;

/**
 * Created by chenpeng on 2020/11/5 10:51
 */
public class T1 {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();//默认时区
        System.out.println(zonedDateTime);
    }
}
