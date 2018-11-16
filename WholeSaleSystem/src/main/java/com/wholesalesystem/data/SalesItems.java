package com.wholesalesystem.data;

public class SalesItems {
    private int si_order_id;
    private int si_product_id;
    private double si_quantity;
    private double si_unit_price;
    private double si_total_price;
    private double si_discounted_price;


    public SalesItems() {
    }

    public SalesItems(int si_order_id, int si_product_id, double si_quantity, double si_unit_price, double si_total_price , double si_discounted_price) {
        this.si_order_id = si_order_id;
        this.si_product_id = si_product_id;
        this.si_quantity = si_quantity;
        this.si_unit_price = si_unit_price;
        this.si_total_price = si_total_price;
    }

    public int getSi_order_id() {
        return si_order_id;
    }

    public void setSi_order_id(int si_order_id) {
        this.si_order_id = si_order_id;
    }

    public int getSi_product_id() {
        return si_product_id;
    }

    public void setSi_product_id(int si_product_id) {
        this.si_product_id = si_product_id;
    }

    public double getSi_quantity() {
        return si_quantity;
    }

    public void setSi_quantity(double si_quantity) {
        this.si_quantity = si_quantity;
    }

    public double getSi_unit_price() {
        return si_unit_price;
    }

    public void setSi_unit_price(double si_unit_price) {
        this.si_unit_price = si_unit_price;
    }

    public double getSi_total_price() {
        return si_total_price;
    }

    public void setSi_total_price(double si_total_price) {
        this.si_total_price = si_total_price;
    }

    public double getSi_discounted_price() {
        return si_discounted_price;
    }

    public void setSi_discounted_price(double si_discounted_price) {
        this.si_discounted_price = si_discounted_price;
    }

    @Override
    public String toString() {
        return "SalesItems{" +
                "si_order_id=" + si_order_id +
                ", si_product_id=" + si_product_id +
                ", si_quantity=" + si_quantity +
                ", si_unit_price=" + si_unit_price +
                ", si_total_price=" + si_total_price +
                ", si_discounted_price=" + si_discounted_price +
                '}';
    }
}
