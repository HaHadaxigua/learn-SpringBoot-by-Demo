package dh.study.springbootconsumingrestfulwebservice;

import dh.study.springbootconsumingrestfulwebservice.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootConsumingRestfulWebServiceApplication {
    private Logger log = LoggerFactory.getLogger(SpringBootConsumingRestfulWebServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumingRestfulWebServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class
            );
            log.info(quote.toString());
        };
    }
}
