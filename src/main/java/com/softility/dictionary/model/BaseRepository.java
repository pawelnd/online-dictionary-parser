package com.softility.dictionary.model;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
 
    void delete(T deleted);
 
    List<T> findAll();
     
    Optional<T> findOne(ID id);
 
    T save(T persisted);
}