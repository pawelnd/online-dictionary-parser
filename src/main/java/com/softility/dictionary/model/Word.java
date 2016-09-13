package com.softility.dictionary.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String word;

    @Enumerated(EnumType.STRING)
    private PartOfSpeech partOfSpeech;

    @Column
    private Date lastUpdate;
}