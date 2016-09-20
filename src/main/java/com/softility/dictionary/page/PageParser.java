package com.softility.dictionary.page;

import com.softility.dictionary.utils.HrefToUrlConverter;
import com.softility.dictionary.utils.PageContentGrabber;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class PageParser {
    @Autowired
    PageContentGrabber pageContentGrabber;

    Page parsePage(URL pageURL) throws IOException {
        String content = pageContentGrabber.getContent(pageURL);
        Page page = new Page();
        page.setWords(getAllWords(content, pageURL));
        page.setCurrentPageAddress(pageURL);
        page.setNextPageAddress(getNextPageURL(content,pageURL));
        return page;
    }

    private List<WordData> getAllWords(String content, URL pageURL) {
        Elements elements = Jsoup.parse(content).body().select(".mw-category a");
        return elements.stream()
                .map(x -> {
                    String href = x.attr("href");
                    String word = x.text();
                    return new WordData(word,HrefToUrlConverter.getFullPath(href,pageURL));
                })
                .filter(x -> x != null)
                .collect(Collectors.toList());
    }

    private URL getNextPageURL(String content, URL pageURL){
        Elements elements = Jsoup.parse(content).body().select("#mw-pages a");
        Element last = elements.last();
        return HrefToUrlConverter.getFullPath(last.attr("href"),pageURL);
    }
}
