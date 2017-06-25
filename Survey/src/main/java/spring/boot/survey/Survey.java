package spring.boot.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Survey {
	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(Survey.class, args);
	}
}
