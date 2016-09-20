package com.softility.dictionary.utils;


import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class SimplePageContentGrabber implements PageContentGrabber {
    @Override
    public String getContent(URL url) throws IOException {
        return Jsoup.connect(url.toString()).get().html();
    }
}
