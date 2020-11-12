package com.crow.crow.article;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Article {
    private final UUID id;
    private final String title;
    private final String author;
    private final String post_date;
    private final String content;
    private final String url;

    public Article(@JsonProperty("id") UUID id,
                   @JsonProperty("title") String title,
                   @JsonProperty("author") String author,
                   @JsonProperty("post_date") String post_date,
                   @JsonProperty("content") String content,
                   @JsonProperty("url") String url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.post_date = post_date;
        this.content = content;
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() { return author; }

    public String getPost_date() {
        return post_date;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }
}
