package com.wholesalesystem.data;

import oracle.sql.BLOB;

public class Products {
    private int product_id;
    private String product_name;
    private String product_desc;
    private String product_img;
    private double product_price;
    private String product_type;
    private int margin_per;


    public Products() {
        super();
    }

    public Products(int product_id, String product_name, String product_desc, String product_img, double product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_img = product_img;
        this.product_price = product_price;

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getMargin() {
        return margin_per;
    }

    public void setMargin(int margin_per) {
        this.margin_per = margin_per;
    }



    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_desc='" + product_desc + '\'' +
                ", product_img='" + product_img + '\'' +
                ", product_price=" + product_price +
                '}';
    }
}
