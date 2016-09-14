package com.softility.dictionary.utils;


import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class SimplePageContentGrabber implements PageContentGrabber {
    @Override
    public String getContent(String url) throws IOException {
        return Jsoup.connect(url).get().html();
    }
}
