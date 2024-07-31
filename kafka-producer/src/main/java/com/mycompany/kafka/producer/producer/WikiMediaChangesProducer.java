package com.mycompany.kafka.producer.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.mycompany.kafka.producer.configs.WikiMediaProperties;
import com.mycompany.kafka.producer.handler.WikiMediaChangesHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class WikiMediaChangesProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final WikiMediaProperties wikiMediaProperties;

    public  void sendMessage() throws InterruptedException{
        //to read real time string data from wikimedia, we use event source
        EventHandler eventHandler = new WikiMediaChangesHandler(kafkaTemplate, wikiMediaProperties.getRecent_changes_kaftaTopic());
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(wikiMediaProperties.getEventSourceUrl()));
         builder.build().start();
        TimeUnit.MINUTES.sleep(1);
    }

}
