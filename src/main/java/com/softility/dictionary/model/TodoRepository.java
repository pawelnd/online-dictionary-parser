package com.softility.dictionary.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

interface TodoRepository extends Repository<Todo, Long>, QueryDslPredicateExecutor<Todo> {

    void delete(Todo deleted);

    List<Todo> findAll();

    /**
     * This query method creates the invoked query method by parsing it from the method name of the query method.
     * @param descriptionPart   The part that must be found from the description of the todo entry.
     * @param titlePart         The part that must be found from the title of the todo entry.
     * @param pageRequest       The information of the requested page.
     * @return  A page of todo entries whose title or description contains with the given search term. The content of
     *          the returned page depends from the page request given as a method parameter.
     */
    Page<Todo> findByDescriptionContainsOrTitleContainsAllIgnoreCase(String descriptionPart,
                                                                     String titlePart,
                                                                     Pageable pageRequest);

    /**
     * This query method creates the invoked query method by parsing it from the method name of the query method.
     * @param descriptionPart   The part that must be found from the description of the todo entry.
     * @param titlePart         The part that must be found from the title of the todo entry.
     * @return  A list of todo entries whose title or description contains with the given search criteria. The returned
     *          todo entries are sorted in alphabetical order by using the title of the todo entry.
     */
    List<Todo> findByDescriptionContainsOrTitleContainsAllIgnoreCaseOrderByTitleAsc(String descriptionPart,
                                                                                    String titlePart);

    Optional<Todo> findOne(Long id);

    void flush();

    Todo save(Todo persisted);
}