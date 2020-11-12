package com.crow.crow.site;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Site {
    private final UUID id;
    private final String name;
    private final String url;
    private final String accuracy;

    public Site(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("url") String url,
                @JsonProperty("accuracy") String accuracy) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.accuracy = accuracy;
    }
}