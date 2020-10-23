package com.crow.crow.scraper;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.util.ArrayList;
import java.util.List;

public class Article {

    private String title;
    private String author;
    private String postDate;
    private String url;
    private String content;
//    private List<String> links = new ArrayList<String>();
//    private List<String> tags = new ArrayList<String>();

//    Dictionary of predicted prices and date of prediction

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPredictions() {
        ;
    }
}
