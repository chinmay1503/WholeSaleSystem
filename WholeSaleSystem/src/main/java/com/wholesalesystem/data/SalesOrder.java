package com.wholesalesystem.data;

import java.util.Date;

public class SalesOrder {

    private int salesord_id;
    private int so_buyer_id;
    private double saleprice;
    private Date saledate;
    private String payment_status;
    private String order_status;
    private Date deliverydate;

    public SalesOrder() {
    }

    public SalesOrder(int salesord_id, int so_buyer_id, double saleprice, Date saledate, String payment_status, String order_status) {
        this.salesord_id = salesord_id;
        this.so_buyer_id = so_buyer_id;
        this.saleprice = saleprice;
        this.saledate = saledate;
        this.payment_status = payment_status;
        this.order_status = order_status;
    }

    public int getSalesord_id() {
        return salesord_id;
    }

    public void setSalesord_id(int salesord_id) {
        this.salesord_id = salesord_id;
    }

    public int getSo_buyer_id() {
        return so_buyer_id;
    }

    public void setSo_buyer_id(int so_buyer_id) {
        this.so_buyer_id = so_buyer_id;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public Date getSaledate() {
        return saledate;
    }

    public void setSaledate(Date saledate) {
        this.saledate = saledate;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "salesord_id=" + salesord_id +
                ", so_buyer_id=" + so_buyer_id +
                ", saleprice=" + saleprice +
                ", saledate=" + saledate +
                ", payment_status='" + payment_status + '\'' +
                ", order_status='" + order_status + '\'' +
                ", deliverydate=" + deliverydate +
                '}';
    }
}
