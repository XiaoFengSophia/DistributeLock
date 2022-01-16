package com.zxf;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DistributeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributeApplication.class, args);
	}

//	@Bean
//	public Redisson redisson(){
//		// 此为单机模式
//		Config config = new Config();
//		config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
//		return (Redisson) Redisson.create(config);
//	}
}
