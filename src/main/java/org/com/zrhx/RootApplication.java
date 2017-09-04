package org.com.zrhx;

import org.com.zrhx.annotation.MyBatisDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
 *
 * Created by JK on 2017/1/17.
 */
@ComponentScan("org.com.zrhx")
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@EnableAutoConfiguration
@MapperScan(value = "org.com.zrhx.mapper",annotationClass = MyBatisDao.class)
@SpringBootApplication
public class RootApplication {

    
    public static void main(String[] args) {
        SpringApplication.run(RootApplication.class, args);
    }
    

}
