package com.softility.dictionary.page;

import com.softility.dictionary.model.WordRepository;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class NextPageDecider {
    private final String INIT_WORD = "config.starting.word";
    private final String ITEMS_LIST_PAGE_ADDRESS = "config.dictionary.page.address";

    @Autowired
    Environment environment;
    @Autowired
    private WordRepository wordRepository;

    public URL getNextPage(ExecutionContext executionContext){
        URL url;
        url = getFromExecutionContext(executionContext);
        if(url == null){
            url = getFromDatabase();
        }
        if(url == null){
            url = getFromProperties();
        }
        return url;
    }

    private URL getFromExecutionContext(ExecutionContext executionContext) {
        Page page = (Page) executionContext.get("page");
        if(page != null){
            return page.getNextPageAddress();
        }
        return null;
    }

    private URL getFromDatabase() {
        String recentlyAddedWord = wordRepository.getLastAdded();
        if(recentlyAddedWord != null){
            return buildPageURL(recentlyAddedWord);
        }
        return null;
    }

    private URL getFromProperties() {
        String recentlyAdded =  environment.getProperty(INIT_WORD);
        return buildPageURL(recentlyAdded);
    }

    private URL buildPageURL(String lastReceivedWord) {
        String pageAddress = environment.getProperty(ITEMS_LIST_PAGE_ADDRESS);
        pageAddress = pageAddress.replace("%FROM_WORD%",lastReceivedWord);
        try {
            return new URL(pageAddress);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
