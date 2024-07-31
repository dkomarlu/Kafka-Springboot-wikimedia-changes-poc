package com.mycompany.kafka.consumer;

import com.mycompany.kafka.consumer.service.WikiMediaService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumerToMySqlDB {
    private WikiMediaService wikiMediaService;
    @KafkaListener(topics = "${kafka.source.topic}")
    public  void consume(String eventMessage) {
        wikiMediaService.saveWikiMediaChanges(eventMessage);
    }
}
