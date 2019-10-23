package com.athlete.ranking;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@SpringBootApplication
@MapperScan("com.athlete.ranking.mapper")
@RestController
public class RankingApplication extends SpringBootServletInitializer {

    @RequestMapping(value = "/index")
    public String index(){
        return "This is my first spring boot project!";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello,Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(RankingApplication.class, args);
    }

}
