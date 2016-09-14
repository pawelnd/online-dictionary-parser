package com.softility.dictionary.utils;

import java.io.IOException;

/**
 * Created by idea8 on 2016-09-15.
 */
public interface PageContentGrabber {
    String getContent(String url) throws IOException;
}
