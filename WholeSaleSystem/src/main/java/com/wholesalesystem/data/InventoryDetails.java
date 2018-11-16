package com.wholesalesystem.data;

public class InventoryDetails {
    private int product_id;
    private String product_name;
    private String product_desc;
    private String product_img;
    private double product_price;
    private String product_type;
    private int margin_per;
    private int inv_product_id;
    private double product_quantity;
    private double min_stock_level;

    public InventoryDetails() {
    }

    public InventoryDetails(int product_id, String product_name, String product_desc, String product_img, double product_price, String product_type, int margin_per, int inv_product_id, double product_quantity, double min_stock_level) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_img = product_img;
        this.product_price = product_price;
        this.product_type = product_type;
        this.margin_per = margin_per;
        this.inv_product_id = inv_product_id;
        this.product_quantity = product_quantity;
        this.min_stock_level = min_stock_level;
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

    public int getMargin_per() {
        return margin_per;
    }

    public void setMargin_per(int margin_per) {
        this.margin_per = margin_per;
    }

    public int getInv_product_id() {
        return inv_product_id;
    }

    public void setInv_product_id(int inv_product_id) {
        this.inv_product_id = inv_product_id;
    }

    public double getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(double product_quantity) {
        this.product_quantity = product_quantity;
    }

    public double getMin_stock_level() {
        return min_stock_level;
    }

    public void setMin_stock_level(double min_stock_level) {
        this.min_stock_level = min_stock_level;
    }

    @Override
    public String toString() {
        return "InventoryDetails{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_desc='" + product_desc + '\'' +
                ", product_img='" + product_img + '\'' +
                ", product_price=" + product_price +
                ", product_type='" + product_type + '\'' +
                ", margin_per=" + margin_per +
                ", inv_product_id=" + inv_product_id +
                ", product_quantity=" + product_quantity +
                ", min_stock_level=" + min_stock_level +
                '}';
    }
}
