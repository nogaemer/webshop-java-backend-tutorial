package de.nogaemer.java.backend.test.webshop.model;

import java.util.List;

public record ProductCreateRequest(String name, String description, Long priceInCents, List<String> tags) {

}
