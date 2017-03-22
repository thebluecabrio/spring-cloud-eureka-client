package com.thebluecabrio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClientApplication.class, args);
	}

	@Value("${teams}")
	private String teams;

	@RequestMapping("/")
	public @ResponseBody String getTeam() {

		String[] teamArray = teams.split(",");

		int i = (int)Math.round(Math.random() * (teamArray.length - 1));

		return teamArray[i];
	}
}
