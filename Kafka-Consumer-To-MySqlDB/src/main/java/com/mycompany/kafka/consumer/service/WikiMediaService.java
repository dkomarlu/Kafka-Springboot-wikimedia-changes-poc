package com.mycompany.kafka.consumer.service;

import com.mycompany.kafka.consumer.entity.WikiMediaEntity;
import com.mycompany.kafka.consumer.repository.WikiMediaRepo;
import lombok.AllArgsConstructor;
import org.hibernate.engine.jdbc.ClobProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WikiMediaService {
    private WikiMediaRepo wikiMediaRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaService.class);
    public void saveWikiMediaChanges (String wikiEventData) {
        LOGGER.info(String.format("Saving Event Message Event to DB -> %s", wikiEventData));
        WikiMediaEntity wikiMediaEntity = WikiMediaEntity.builder()
                .wikiEventData(ClobProxy.generateProxy(wikiEventData))
                .build();
        wikiMediaRepo.save(wikiMediaEntity);
    }
}
