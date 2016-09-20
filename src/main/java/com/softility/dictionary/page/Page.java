package com.softility.dictionary.page;

import lombok.Data;

import java.io.Serializable;
import java.net.URL;
import java.util.List;

@Data
public class Page implements Serializable {
    private URL currentPageAddress;
    private URL nextPageAddress;
    private List<WordData> words;
}
