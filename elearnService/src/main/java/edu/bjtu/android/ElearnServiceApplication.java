package edu.bjtu.android;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.bjtu.android.dao")
public class ElearnServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ElearnServiceApplication.class, args);
	}

}
