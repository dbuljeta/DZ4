package com.example.daniel.rss_reader.interfaces;

import com.example.daniel.rss_reader.helpers.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by daniel on 23.4.2017..
 */

public interface RSSAPI {
    @GET("vijesti/")
    Call<SearchResult> getRSS();
}

