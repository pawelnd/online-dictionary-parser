package com.softility.dictionary.page;

import com.softility.dictionary.model.WordRepository;
import com.softility.dictionary.utils.PageContentGrabber;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ItemsListPageContentProducer implements ItemReader {
    @Autowired
    Environment environment;
    @Autowired
    private WordRepository wordRepository;
    private
    int limiter = 0;
    private String initializationWord = "config.starting.word";
    private String itemsListPageAddress = "config.dictionary.page.address";

    @Autowired
    PageContentGrabber pageContentGrabber;

    @Override
    public String read() throws Exception {
        if(limiter++ > 0){
            String lastReceivedWord = getLassReceivedWord();
            return pageContentGrabber.getContent(buildPageURL(lastReceivedWord));
        }
        return null;
    }

    private String buildPageURL(String lastReceivedWord) {
        String pageAddress = environment.getProperty(itemsListPageAddress);
        return pageAddress.replace("%FROM_WORD%",lastReceivedWord);
    }

    private String getLassReceivedWord() {
        String recentlyAdded = wordRepository.getLastAdded();
        if(recentlyAdded == null){
            recentlyAdded =  environment.getProperty(initializationWord);

        }
        return recentlyAdded;
    }
}
