package com.mycompany.kafka.consumer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;

@Entity
@Table(name = "wiki_media_recentchange")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WikiMediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "wiki_event_data")
    private Clob wikiEventData;

}
