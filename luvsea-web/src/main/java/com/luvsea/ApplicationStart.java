package com.luvsea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.core.io.support.SpringFactoriesLoader;
//import org.springframework.boot.web.filter.OrderedHttpPutFormContentFilter;
//import org.springframework.core.io.
@SpringBootApplication
//@ComponentScan("com.luvsea.abc.*")
@EnableConfigurationProperties
public class ApplicationStart {

//    public void test(){
//        System.out.println("this is first test for spring boot");
//    }
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
