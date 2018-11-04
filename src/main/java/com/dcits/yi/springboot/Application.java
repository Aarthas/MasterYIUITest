package com.dcits.yi.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.dcits.yi.springboot.config.SpringConfiguration;

@SpringBootApplication
@Import(SpringConfiguration.class)
public class Application {
	
}
