package com.lookup.lookup.products;

import com.lookup.lookup.BaseResponse;

public class Product extends BaseResponse<Product> {

    private String title;
    private String description;
    private Double price;

    public Product(long id, String title, double price, String description) {
        setId(id);
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
