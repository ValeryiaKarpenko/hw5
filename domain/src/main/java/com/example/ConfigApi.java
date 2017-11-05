package com.example;

/**
 * Created by IT on 26.10.2017.
 */

public class ConfigApi {
    private static final String CONFIG = "config?";

    private String mBasePath;

    public ConfigApi(final String pBasePath) {
        if (pBasePath.charAt(pBasePath.length() - 1) == '/') {
            mBasePath = pBasePath;
        } else {
            mBasePath = pBasePath + "/";
        }
    }




}