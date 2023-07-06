package de.nogaemer.java.backend.test.webshop.model;

import java.util.List;

public class ProductCreateRequest {

    private final String name;
    private final String description;
    private final String priceInCents;
    private final List<String> tags;

    public ProductCreateRequest(String name, String description, String priceInCents, List<String> tags) {
        this.name = name;
        this.description = description;
        this.priceInCents = priceInCents;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPriceInCents() {
        return priceInCents;
    }

    public List<String> getTags() {
        return tags;
    }
}
