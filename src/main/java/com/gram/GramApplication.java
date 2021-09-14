package com.gram;

import java.util.Locale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;

import com.gram.config.MessageConfig;

@SpringBootApplication
@MapperScan
public class GramApplication {

	public static void main(String[] args) {
		SpringApplication.run(GramApplication.class, args);
	}

}
