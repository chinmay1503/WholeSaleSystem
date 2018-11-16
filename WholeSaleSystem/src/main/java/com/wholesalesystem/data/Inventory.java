package com.wholesalesystem.data;

public class Inventory {
    private int inv_product_id;
    private double product_quantity;
    private double min_stock_level;

    public Inventory() {
    }

    public Inventory(int inv_product_id, double product_quantity, double min_stock_level) {
        this.inv_product_id = inv_product_id;
        this.product_quantity = product_quantity;
        this.min_stock_level = min_stock_level;
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
        return "Inventory{" +
                "inv_product_id=" + inv_product_id +
                ", product_quantity=" + product_quantity +
                ", min_stock_level=" + min_stock_level +
                '}';
    }
}
