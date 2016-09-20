package com.softility.dictionary.page.word;

import com.softility.dictionary.page.Page;
import com.softility.dictionary.page.WordData;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;

import java.util.List;


public class WordProcessor implements ItemProcessor<WordData,WordData> {

    @Override
    public WordData process(WordData wordData) throws Exception {
        System.out.println(wordData.getWord());
        return wordData;
    }
}
