package org.example.springsecuritylian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan("org.example.springsecuritylian.mapper")
public class SpringSecurityLianApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringSecurityLianApplication.class, args);
        PasswordEncoder bean = run.getBean(PasswordEncoder.class);
        String encode = bean.encode("123");
        System.out.println(encode);
    }

}
