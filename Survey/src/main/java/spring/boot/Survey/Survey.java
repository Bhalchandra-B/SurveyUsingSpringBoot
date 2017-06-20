package spring.boot.Survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import spring.boot.domain.SurveyEntity;

@SpringBootApplication
@ComponentScan("spring.boot")
public class Survey 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = SpringApplication.run(Survey.class, args);
    }
}
