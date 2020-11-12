package com.crow.crow.article;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Article {
    private final UUID id;
    private final String title;
    private final String author;
    private final String postDate;
    private String content;
    private final String url;

    public Article(@JsonProperty("id") UUID id,
                   @JsonProperty("title") String title,
                   @JsonProperty("author") String author,
                   @JsonProperty("postDate") String postDate,
                   @JsonProperty("content") String content,
                   @JsonProperty("url") String url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.postDate = postDate;
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

    public String getPostDate() {
        return postDate;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
