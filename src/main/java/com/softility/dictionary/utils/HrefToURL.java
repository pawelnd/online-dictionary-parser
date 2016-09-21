package com.softility.dictionary.utils;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;


public class HrefToURL {
    private static final Logger log = Logger.getLogger(HrefToURL.class);
    public static URL getFullPath(String href, URL fullAddress) {
        try {
            return new URL(fullAddress, href);
        } catch (MalformedURLException e) {
            log.error(e);
            return null;
        }
    }
}
