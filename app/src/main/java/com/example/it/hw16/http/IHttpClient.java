package com.example.it.hw16.http;

/**
 * Created by IT on 26.10.2017.
 */

public interface IHttpClient {
    void request(String url, HttpClient.ResponseListener listener);
}
