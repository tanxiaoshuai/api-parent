package cn.nmmpa.field;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lhm
 * @date 2019/8/29 17:43
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"cn.nmmpa"})
public class FieldServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FieldServiceApplication.class,args);
    }
}
