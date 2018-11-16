package com.wholesalesystem.data;

public class PurchaseItems {
    private int pi_purchase_id;
    private int pi_product_id;
    private double pi_quantity;
    private double pi_unit_price;
    private double pi_total_price;

    public PurchaseItems() {
    }

    public PurchaseItems(int pi_purchase_id, int pi_product_id, double pi_quantity, double pi_unit_price, double pi_total_price) {
        this.pi_purchase_id = pi_purchase_id;
        this.pi_product_id = pi_product_id;
        this.pi_quantity = pi_quantity;
        this.pi_unit_price = pi_unit_price;
        this.pi_total_price = pi_total_price;
    }

    public int getPi_purchase_id() {
        return pi_purchase_id;
    }

    public void setPi_purchase_id(int pi_purchase_id) {
        this.pi_purchase_id = pi_purchase_id;
    }

    public int getPi_product_id() {
        return pi_product_id;
    }

    public void setPi_product_id(int pi_product_id) {
        this.pi_product_id = pi_product_id;
    }

    public double getPi_quantity() {
        return pi_quantity;
    }

    public void setPi_quantity(double pi_quantity) {
        this.pi_quantity = pi_quantity;
    }

    public double getPi_unit_price() {
        return pi_unit_price;
    }

    public void setPi_unit_price(double pi_unit_price) {
        this.pi_unit_price = pi_unit_price;
    }

    public double getPi_total_price() {
        return pi_total_price;
    }

    public void setPi_total_price(double pi_total_price) {
        this.pi_total_price = pi_total_price;
    }

    @Override
    public String toString() {
        return "PurchaseItems{" +
                "pi_purchase_id=" + pi_purchase_id +
                ", pi_product_id=" + pi_product_id +
                ", pi_quantity=" + pi_quantity +
                ", pi_unit_price=" + pi_unit_price +
                ", pi_total_price=" + pi_total_price +
                '}';
    }
}
