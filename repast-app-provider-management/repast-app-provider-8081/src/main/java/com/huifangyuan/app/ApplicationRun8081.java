package com.huifangyuan.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Company AAA软件教育
 * @Author Lee
 * @Date Create in 2019/11/21 20:33
 * @Description
 **/
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.huifangyuan.app.mapper")
public class ApplicationRun8081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class, args);
    }

}
