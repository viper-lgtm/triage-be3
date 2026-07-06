package cz.martinvedra.triagebe3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class TriageBe3Application {

    public static void main(String[] args) {
        SpringApplication.run(TriageBe3Application.class, args);
    }

}
