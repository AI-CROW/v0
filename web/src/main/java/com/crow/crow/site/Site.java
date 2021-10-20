package com.crow.crow.site;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Site {
    private final UUID id;
    private final String name;
    private final String url;
    private final String accuracy;
    private final String type;

    public String getAccuracy() {
        return accuracy;
    }

    public Site(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("url") String url,
                @JsonProperty("accuracy") String accuracy,
                @JsonProperty("type") String type ) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.accuracy = accuracy;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }
}