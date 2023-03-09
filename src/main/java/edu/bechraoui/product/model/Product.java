package edu.bechraoui.product.model;

import java.util.UUID;

/**
 * Created by aminebechraoui, on 24/02/2023, in edu.bechraoui.product
 */
public class Product {
    private UUID id;
    private String name;
    private String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
