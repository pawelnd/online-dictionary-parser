package com.softility.dictionary.utils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by idea8 on 2016-09-15.
 */
public interface PageContentGrabber {
    String getContent(URL url) throws IOException;
}
