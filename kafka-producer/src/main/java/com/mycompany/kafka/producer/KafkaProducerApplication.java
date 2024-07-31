package com.mycompany.kafka.producer;

import com.mycompany.kafka.producer.producer.WikiMediaChangesProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class KafkaProducerApplication implements CommandLineRunner {

    private WikiMediaChangesProducer wikiMediaChangesProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        wikiMediaChangesProducer.sendMessage();
    }
}
