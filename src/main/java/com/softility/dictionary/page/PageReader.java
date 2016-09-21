package com.softility.dictionary.page;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
*  Part of Spring batch flow.
 *  It is responsible for fetching new word list for
* */
public class PageReader implements ItemReader {
    @Autowired
    Environment environment;
    @Autowired
    PageParser pageParser;

    private int limiter = 0;
    private ExecutionContext jobExecutionContext;

    @Autowired
    NextPageDecider nextPageDecider;

    @Override
    public Page read() throws Exception {
        if(limiter++ == 0){
            return pageParser.parsePage(nextPageDecider.getNextPage(jobExecutionContext));
        }
        return null;
    }

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.jobExecutionContext = stepExecution.getJobExecution().getExecutionContext();
    }

    @AfterStep
    public void clearLimitation(StepExecution stepExecution) {
        this.limiter = 0;
    }
}
