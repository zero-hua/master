package ink.zerohua.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//通过webjars引入资源,访问通过http://localhost:8080/webjars/jquery/3.4.1/jquery.js

@SpringBootApplication
public class SpringbootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootThymeleafApplication.class, args);
    }
}