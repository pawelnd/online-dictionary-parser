package com.softility.dictionary.page.word;

import com.softility.dictionary.page.Page;
import com.softility.dictionary.page.WordData;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;

import java.util.List;


public class WordWriter implements ItemWriter<WordData> {
    private StepExecution stepExecution;

    @Override
    public void write(List<? extends WordData>  contentList) throws Exception {

    }

}
