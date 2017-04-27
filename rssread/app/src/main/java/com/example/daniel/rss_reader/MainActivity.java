package com.example.daniel.rss_reader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.daniel.rss_reader.adapters.RSSAdapter;
import com.example.daniel.rss_reader.helpers.SearchResult;
import com.example.daniel.rss_reader.interfaces.RSSAPI;
import com.example.daniel.rss_reader.models.RSS;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends Activity implements Callback<SearchResult>, View.OnClickListener {
    private static final String BASE_RSS_API = "http://www.bug.hr/rss/";

    ImageButton bRefresh;
    ListView lvRSS;
    Spinner spCategories;

    List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        this.setUpUi();

    }

    private void setUpUi() {
        this.bRefresh = (ImageButton) this.findViewById(R.id.ibRefresh);
        this.lvRSS = (ListView) this.findViewById(R.id.lvRSS);

        spCategories = (Spinner) this.findViewById(R.id.spCategories);
        this.findRSS();
        list = new ArrayList<String>();
        bRefresh.setOnClickListener(this);

        ArrayAdapter<String> adapter;
        list = new ArrayList<String>();
        list.add("All");
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategories.setAdapter(adapter);
    }

    private void findRSS() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_RSS_API)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        RSSAPI rssapi = retrofit.create(RSSAPI.class);
        Call<SearchResult> call = rssapi.getRSS();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
        if (response.isSuccessful()) {
            Log.e("RESPONSE", String.valueOf(response));
            Log.e("BODY", String.valueOf(response.body()));
            Log.e("SUCCESS", String.valueOf(response.isSuccessful()));

            List<RSS> rss = response.body().getRSSList();
            for (RSS test : rss) {
                Log.e("CategoryNAME", test.getmCategory());
                String itemCategory = test.getmCategory();
                Boolean has = list.contains(itemCategory);
                if (has == false) {
                    list.add(itemCategory);
                }
            }
            RSSAdapter adapter = new RSSAdapter(rss);
            this.lvRSS.setAdapter(adapter);


        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<SearchResult> call, Throwable t) {
        // Log.e("Fail", t.getMessage());
        // Log.e("Fail", call.toString());
        // Log.e("Fail", String.valueOf(call.request()));
    }

    @Override
    public void onClick(View v) {
        findRSS();
    }
}