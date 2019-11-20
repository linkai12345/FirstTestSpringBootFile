package com.liaoxukai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.liaoxukai.Dao")
@SpringBootApplication
public class SsmcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmcrudApplication.class, args);
    }

}
