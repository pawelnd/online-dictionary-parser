package com.softility.dictionary.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface WordRepository extends BaseRepository<Word,Long>  {
    @Query("select w from Word w")
    String getLastAdded();
}