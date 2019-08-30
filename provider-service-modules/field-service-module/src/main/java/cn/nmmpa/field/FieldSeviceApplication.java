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
public class FieldSeviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FieldSeviceApplication.class,args);
    }
}
