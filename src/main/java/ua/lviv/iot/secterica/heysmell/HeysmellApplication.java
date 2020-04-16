package ua.lviv.iot.secterica.heysmell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan({"ua.lviv.iot.secterica.heysmell.controller",
//		"ua.lviv.iot.secterica.heysmell.service",
//		"ua.lviv.iot.secterica.heysmell.repository"})
@EnableSwagger2
public class HeysmellApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeysmellApplication.class, args);
	}

}
