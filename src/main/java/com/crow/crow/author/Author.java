package com.crow.crow.author;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Author {
    private final UUID id;
    private final String name;
    private final String accuracy;

    public Author(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("accuracy") String accuracy) {
        this.id = id;
        this.name = name;
        this.accuracy = accuracy;
    }
}