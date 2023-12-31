package com.musiclibraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.musiclibraryapp.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
@ComponentScan(basePackages = "com.musiclibraryapp")
public class MusiclibraryappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusiclibraryappApplication.class, args);
	}

}
