package de.nogaemer.java.backend.test.webshop.utils;

import de.nogaemer.java.backend.test.webshop.model.Model;

import java.util.ArrayList;
import java.util.UUID;

public class UUIDUtils {

    public static String randomUUID(ArrayList<Model> products) {
        while (true){
            String uuid = UUID.randomUUID().toString();
            if (products.stream().filter(p -> p.getId().equals(uuid)).findFirst().orElse(null) == null) {
                return uuid;
            }
        }
    }
}
