package com.example.daniel.rss_reader.helpers;


import com.example.daniel.rss_reader.models.RSS;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;


import java.util.List;

/**
 * Created by daniel on 23.4.2017..
 */

@Root(strict = false, name = "rss")
public class SearchResult {
    @Element(name = "title")
    @Path("channel")
    private String title;

    @ElementList(name = "item", inline = true)
    @Path("channel")
    private List<RSS> rssList;

    public String getTitle() {


        return title;
    }

    public List<RSS> getRSSList() {
        return rssList;
    }
}

