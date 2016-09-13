package com.softility.dictionary.page;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by idea8 on 2016-09-12.
 */
public class PageItemProcessor implements ItemProcessor {
    @Override
    public Object process(Object o) throws Exception {
        System.out.println("PROCESS");
        return o;
    }
}
