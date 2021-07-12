package com.desafiospringboot.DTOs;

import com.desafiospringboot.Entities.Product;

import javax.validation.constraints.NotNull;

public class ProductDTO {
    private int product_id;
    @NotNull
    private String productName;
    @NotNull
    private String type;
    @NotNull
    private String brand;
    @NotNull
    private String color;
    @NotNull
    private String notes;

    public int getProduct_id() {
        return product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.product_id = product.getId();
        this.brand = product.getBrand();
        this.color = product.getColor();
        this.productName = product.getName();
        this.type = product.getType();
        this.notes = product.getNotes();
    }

    public static ProductDTO convert(Product product) {
        return new ProductDTO(product);
    }

    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();

        product.setId(productDTO.getProduct_id());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        product.setName(productDTO.getProductName());
        product.setNotes(productDTO.getNotes());
        product.setType(productDTO.getType());

        return product;
    }
}
