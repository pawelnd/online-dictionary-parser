package com.softility.dictionary.page;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by idea8 on 2016-09-11.
 */
public class PageItemsWriter implements ItemWriter {
    @Override
    public void write(List list) throws Exception {
        System.out.println("WRITE");
    }
}
