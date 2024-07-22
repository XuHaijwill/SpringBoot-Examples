package com.hendisantika.log4j2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName Log4j2App
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/22 1:08
 * @Version 1.0
 **/
@SpringBootTest
@Slf4j
public class Log4j2App {

    @Test
    public void test1(){
        log.trace("trace1234");
        log.info("info123456");
        log.error("error12345");
    }
}
