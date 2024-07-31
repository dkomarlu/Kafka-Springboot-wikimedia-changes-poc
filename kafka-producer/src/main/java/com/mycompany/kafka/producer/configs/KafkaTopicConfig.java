package com.mycompany.kafka.producer.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {

    @Bean
    public WikiMediaProperties getWikiMediaProperties() {
        return new WikiMediaProperties();
    }
}
