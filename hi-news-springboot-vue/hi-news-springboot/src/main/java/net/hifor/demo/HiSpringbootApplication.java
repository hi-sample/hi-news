package net.hifor.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("**.dao")
public class HiSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiSpringbootApplication.class, args);
    }

}
