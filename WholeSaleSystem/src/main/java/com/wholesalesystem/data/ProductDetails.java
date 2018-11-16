package com.wholesalesystem.data;

public class ProductDetails {
    private String product_name;
    private String product_type;
    private Double product_price;

    public ProductDetails() {
    }

    public ProductDetails(String product_name, String product_type) {
        this.product_name = product_name;
        this.product_type = product_type;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "product_name='" + product_name + '\'' +
                ", product_type='" + product_type + '\'' +
                '}';
    }
}
