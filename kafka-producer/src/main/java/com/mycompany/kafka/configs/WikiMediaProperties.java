package com.mycompany.kafka.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.config.TopicBuilder;

import org.apache.kafka.clients.admin.NewTopic;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikiMediaProperties {
    @Value("${event.source.url}")
    private String eventSourceUrl;
    @Value("${event.destination.topic}")
    private String recent_changes_kaftaTopic;

    public NewTopic getTopic() {
        return TopicBuilder.name(eventSourceUrl).build();
    }
}
