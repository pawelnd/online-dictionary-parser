package com.softility.dictionary.page;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.net.URL;

/**
 * Created by idea9 on 2016-09-19.
 */
@Data
@AllArgsConstructor
public class WordData implements Serializable {
    private String word;
    private URL url;
}
