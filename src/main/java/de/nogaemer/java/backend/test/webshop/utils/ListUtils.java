package de.nogaemer.java.backend.test.webshop.utils;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    public static List<String> toLowerCase(List<String> tags) {
        return tags.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
