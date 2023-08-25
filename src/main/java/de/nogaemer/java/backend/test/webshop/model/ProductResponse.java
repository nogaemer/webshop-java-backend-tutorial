package de.nogaemer.java.backend.test.webshop.model;

import java.util.List;

public class ProductResponse implements Model {

    private final String id;
    private final String name;
    private final String description;
    private final Long priceInCents;
    private final List<String> tags;

    public ProductResponse(String id, String name, String description, Long priceInCents, List<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceInCents = priceInCents;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getPriceInCents() {
        return priceInCents;
    }

    public List<String> getTags() {
        return tags;
    }
}
