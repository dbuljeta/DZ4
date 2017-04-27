package com.example.daniel.rss_reader.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by daniel on 23.4.2017..
 */

@Root(name = "item", strict = false)
public class RSS {
    @Element(name = "title")
    private String mTitle;
    @Element(name = "link")
    private String mLink;
    @Element(name = "guid")
    private String mGuid;
    @Element(name = "description")
    private String mDescription;
    @Element(name = "category")
    private String mCategory;
    @Attribute(name = "url", required = false)
    @Path("enclosure")
    private String mUrl;


    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;

    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmGuid() {
        return mGuid;
    }

    public void setmGuid(String mGuid) {
        this.mGuid = mGuid;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmCategory() {

        return mCategory;
    }

    public void setmCategory(String mCategory) {


        this.mCategory = mCategory;
    }
}
