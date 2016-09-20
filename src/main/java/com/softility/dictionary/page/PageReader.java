package com.softility.dictionary.page;

import com.softility.dictionary.model.WordRepository;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.net.MalformedURLException;
import java.net.URL;

/**
*  Part of Spring batch flow.
 *  It is responsible for fetching new word list for
* */
public class PageReader implements ItemReader {
    private final Logger logger  = Logger.getLogger(PageReader.class);
    @Autowired
    Environment environment;
    @Autowired
    private WordRepository wordRepository;
    @Autowired
    PageParser pageParser;

    private int limiter = 0;
    private String initializationWord = "config.starting.word";
    private String itemsListPageAddress = "config.dictionary.page.address";

    @Override
    public Page read() throws Exception {
        if(limiter++ == 0){
            String lastReceivedWord = getLassReceivedWord();
            URL pageUrl = buildPageURL(lastReceivedWord);
            return pageParser.parsePage(pageUrl);
        }
        return null;
    }

    private URL buildPageURL(String lastReceivedWord) {
        String pageAddress = environment.getProperty(itemsListPageAddress);
        pageAddress = pageAddress.replace("%FROM_WORD%",lastReceivedWord);
        try {
            return new URL(pageAddress);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private String getLassReceivedWord() {
        String recentlyAdded = wordRepository.getLastAdded();
        if(recentlyAdded == null){
            recentlyAdded =  environment.getProperty(initializationWord);

        }
        return recentlyAdded;
    }
}
