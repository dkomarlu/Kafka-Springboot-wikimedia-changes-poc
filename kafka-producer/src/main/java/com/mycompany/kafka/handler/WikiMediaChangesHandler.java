package com.mycompany.kafka.handler;

import com.launchdarkly.eventsource.EventHandler;

import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
@AllArgsConstructor
public class WikiMediaChangesHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesHandler.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    @Override
    public void onOpen() throws Exception {
        //No code is needed to implement
    }

    @Override
    public void onClosed() throws Exception {
        //No code is needed to implement
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("event data-> %s", messageEvent.getData()));
        kafkaTemplate.send(topic, messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {
        //No code is needed to implement
    }

    @Override
    public void onError(Throwable throwable) {
        //No code is needed to implement
    }
}
