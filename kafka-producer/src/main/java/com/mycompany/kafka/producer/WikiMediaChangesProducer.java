package com.mycompany.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WikiMediaChangesProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public  void sendMessage() {
        String topic = "wikimedia_recentchange";

        //to read real time string data from wikimedia, we use event source


    }

}
