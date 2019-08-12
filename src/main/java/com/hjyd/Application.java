package com.hjyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program：HjEureka
 * @description：启动程序
 * @author：黄细初
 * @create：2019-04-28 11:26
 */

@SpringBootApplication
@EnableEurekaServer
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
