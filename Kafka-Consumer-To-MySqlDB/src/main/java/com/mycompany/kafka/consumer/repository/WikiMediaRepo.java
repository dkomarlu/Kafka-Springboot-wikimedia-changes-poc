package com.mycompany.kafka.consumer.repository;

import com.mycompany.kafka.consumer.entity.WikiMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaRepo extends JpaRepository<WikiMediaEntity, Long> {
}
