package com.mycompany.kafka.producer.configs;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
@Data
@NoArgsConstructor
public class WikiMediaProperties {
    @Value("${event.source.url}")
    private String eventSourceUrl;
    @Value("${event.destination.topic}")
    private String recent_changes_kaftaTopic;
}
