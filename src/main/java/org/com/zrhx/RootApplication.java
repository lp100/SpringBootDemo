package org.com.zrhx;

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
@Configuration
@ComponentScan
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@EnableAutoConfiguration
@MapperScan("org.com.zrhx.mapper")
@SpringBootApplication
public class RootApplication {
    public static final String MAX_FILE_SIZE = "1MB";
    public static final String MAX_REQUEST_SIZE = "1MB";
    public static final String FILE_SIZE_THRESHOLD = "1MB";

    private static final String FILE_UPLOAD_PATH = "/goodmanage/attachment";
    
    public static void main(String[] args) {
        SpringApplication.run(RootApplication.class, args);
    }
    

}
