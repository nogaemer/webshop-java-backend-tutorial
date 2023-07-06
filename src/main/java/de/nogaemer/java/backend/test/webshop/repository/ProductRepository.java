package de.nogaemer.java.backend.test.webshop.repository;

import de.nogaemer.java.backend.test.webshop.model.Model;
import de.nogaemer.java.backend.test.webshop.model.ProductCreateRequest;
import de.nogaemer.java.backend.test.webshop.model.ProductResponse;
import de.nogaemer.java.backend.test.webshop.utils.ListUtils;

import java.util.*;
import java.util.stream.Collectors;

import static de.nogaemer.java.backend.test.webshop.utils.UUIDUtils.randomUUID;

public class ProductRepository {

    private final ArrayList<ProductResponse> products = new ArrayList<>();

    public ProductRepository() {
        products.add(
                new ProductResponse(
                        randomUUID((ArrayList<Model>) products.stream()
                                .map(p -> (Model) p)
                                .collect(Collectors.toList())),
                        "AMD Ryzen 9 7950X",
                        "Der neue Prozessor",
                        "79900",
                        Arrays.asList("AMD", "Ryzen", "Processor", "CPU", "7950X", "16 Kerne", "32 Threads", "4,5 GHz", "4,7 GHz", "AM4", "7nm", "Zen 2", "PCIe 4.0", "Wraith Prism")
        ));
        products.add(
                new ProductResponse(
                        randomUUID((ArrayList<Model>) products.stream()
                                .map(p -> (Model) p)
                                .collect(Collectors.toList())),
                        "Intel Core i9-9900K",
                        "Der neue Prozessor",
                        "59900",
                        Arrays.asList("Intel", "Core", "Processor", "CPU", "9900K", "8 Kerne", "16 Threads", "3,6 GHz", "5,0 GHz", "LGA 1151", "14nm", "Coffee Lake", "PCIe 3.0", "Wasserkühlung")
        ));
        products.add(
                new ProductResponse(
                        randomUUID((ArrayList<Model>) products.stream()
                                .map(p -> (Model) p)
                                .collect(Collectors.toList())),
                        "NVIDIA GeForce RTX 2080 Ti",
                        "Die neue Grafikkarte",
                        "119900",
                        Arrays.asList("NVIDIA", "RTX", "Grafikkarte", "GPU", "2080 Ti", "11 GB", "GDDR6", "PCIe 3.0", "Raytracing", "DLSS", "4K", "VR", "Virtual Reality", "Gaming", "Overclocking", "Wasserkühlung")
        ));
    }

    public ArrayList<ProductResponse> findAll(List<String> tags){
        if (tags == null) {
            return products;
        } else {
            List<String> lowerCaseTags = ListUtils.toLowerCase(tags);

            return products
                    .stream()
                    .filter(productResponse -> new HashSet<>(ListUtils.toLowerCase(productResponse.getTags())).containsAll(lowerCaseTags))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    public ProductResponse findById(String id) {
        Optional<ProductResponse> product = products
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return product.orElse(null);
    }

    public void deleteById(String id) {
        products.removeIf(productResponse -> productResponse.getId().equals(id));
    }

    public ProductResponse save(ProductCreateRequest request) {
        ProductResponse product = new ProductResponse(
                randomUUID((ArrayList<Model>) products.stream()
                        .map(p -> (Model) p)
                        .collect(Collectors.toList())),
                request.getName(),
                request.getDescription(),
                request.getPriceInCents(),
                request.getTags()
        );
        products.add(product);
        return product;
    }
}
