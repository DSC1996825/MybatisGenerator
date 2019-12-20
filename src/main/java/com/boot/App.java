package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.boot.mapper.*")
public class App {

  public static void main(String[] args) {
    System.out.println("SpringBoot启动中...");
    SpringApplication.run(App.class, args);
    System.out.println("SpringBoot启动完成！！！");
  }
}
