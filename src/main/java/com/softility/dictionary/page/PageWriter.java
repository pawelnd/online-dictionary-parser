package com.softility.dictionary.page;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * It passes data for next job step
 */
public class PageWriter implements ItemWriter<Page> {
    private StepExecution stepExecution;

    @Override
    public void write(List<? extends Page>  contentList) throws Exception {
        contentList.forEach(this::passPageToNextStep);
    }

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    private void passPageToNextStep(Page page) {
        ExecutionContext stepContext = this.stepExecution.getJobExecution().getExecutionContext();
        stepContext.put("page", page);
    }
}
