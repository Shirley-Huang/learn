package com.dandan.mapper;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dandan On 八月 25 2019
 */
@SpringBootApplication
public  class AbstractPersistenceTest {

    public static void main(String[] args) {
        SpringApplication.run(AbstractPersistenceTest.class);
    }

}
