package de.nogaemer.java.backend.test.webshop.model;

import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private String priceInCents;
    private List<String> tags;

    public ProductResponse(String id, String name, String description, String priceInCents, List<String> tags) {
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

    public String getPriceInCents() {
        return priceInCents;
    }

    public List<String> getTags() {
        return tags;
    }
}
