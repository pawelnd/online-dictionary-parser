package com.softility.dictionary.utils;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class HrefToUrlConverter {
    private static final Logger log = Logger.getLogger(HrefToUrlConverter.class);
    public static URL getFullPath(String href, URL fullAddress) {
        try {
            if(href.startsWith("/")){
                return new URL(fullAddress.toURI().toString() + href );
            }else{
                return new URL(fullAddress.getProtocol() + "://" +fullAddress.getHost() + "/" + href);
            }
        } catch (MalformedURLException | URISyntaxException e) {
            log.error(e);
            return null;
        }
    }
}
