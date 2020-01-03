package dh.study.springbootschedulingtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSchedulingTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSchedulingTasksApplication.class, args);
    }

}
