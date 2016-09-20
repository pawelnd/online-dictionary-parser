package com.softility.dictionary.page.word;

import com.softility.dictionary.model.WordRepository;
import com.softility.dictionary.page.Page;
import com.softility.dictionary.page.PageParser;
import com.softility.dictionary.page.WordData;
import org.apache.log4j.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

/**
*  Part of Spring batch flow.
 *  It is responsible for fetching new word list for
* */
public class WordReader implements ItemReader<WordData> {
    @Autowired
    PageParser pageParser;

    private Page page;
    private volatile int counter;


    @Override
    public WordData read() throws Exception {
        if(page != null){
            if(counter < page.getWords().size() ){
                return page.getWords().get(counter++);
            }
        }
        return null;
    }

    @BeforeStep
    public void retrieveInterstepData(StepExecution stepExecution) {
        JobExecution jobExecution = stepExecution.getJobExecution();
        ExecutionContext jobContext = jobExecution.getExecutionContext();
        this.page = (Page) jobContext.get("page");

    }
}
