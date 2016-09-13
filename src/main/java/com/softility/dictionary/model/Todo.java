package com.softility.dictionary.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "todos")
final class Todo {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column(name = "creation_time", nullable = false)
    private Date creationTime;
 
    @Column(name = "description", length = 500)
    private String description;
 
    @Column(name = "modification_time")
    private Date modificationTime;
 
    @Column(name = "title", nullable = false, length = 100)
    private String title;
 
    @Version
    private long version;
     
    //The constructor, builder, and other methods are omitted
}