package com.softility.dictionary.utils;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by idea9 on 2016-09-16.
 */
public class HrefToUrlConverterTest {
    private URL url;

    @Before
    public void prepare() throws MalformedURLException {
        url = new URL("http://domain.com");
    }

    @Test
    public void testGetFullPathForRelative() throws Exception {
        URL fullPath = HrefToUrlConverter.getFullPath("relative/path", url);
        assertEquals("http://domain.com/relative/path",fullPath.toString());

    }

    @Test
    public void testGetFullPathForAbsolute() throws Exception {
        URL fullPath = HrefToUrlConverter.getFullPath("/absolute/path", url);
        assertEquals("http://domain.com/absolute/path",fullPath.toString());
    }
}