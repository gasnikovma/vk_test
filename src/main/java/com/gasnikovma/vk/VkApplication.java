package com.gasnikovma.vk;

import com.gasnikovma.vk.configuration.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
@EnableCaching
public class VkApplication {

	public static void main(String[] args) {
		SpringApplication.run(VkApplication.class, args);
	}

}
