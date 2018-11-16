package com.wholesalesystem.data;

import java.time.LocalDate;

public class OrderDetails {
            //Buyer Related variables
            private String buyer_name;
            private String buyer_address;
            private String buyer_phone_no;
            //Order Related Variables
            private double saleprice;
            private LocalDate saledate;
            private String order_status;
            private String payment_status;
    //        private Date deliverydate;
            //Item Related variables
            private int product_id;
            private double quantity;
            private double unit_price;
            private double total_price;

    public OrderDetails() {
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyer_address() {
        return buyer_address;
    }

    public void setBuyer_address(String buyer_address) {
        this.buyer_address = buyer_address;
    }

    public String getBuyer_phone_no() {
        return buyer_phone_no;
    }

    public void setBuyer_phone_no(String buyer_phone_no) {
        this.buyer_phone_no = buyer_phone_no;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public LocalDate getSaledate() {
        return saledate;
    }

    public void setSaledate(LocalDate saledate) {
        this.saledate = saledate;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

/*
    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }
*/

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "buyer_name='" + buyer_name + '\'' +
                ", buyer_address='" + buyer_address + '\'' +
                ", buyer_phone_no='" + buyer_phone_no + '\'' +
                ", saleprice=" + saleprice +
                ", saledate=" + saledate +
                ", order_status='" + order_status + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", total_price=" + total_price +
                '}';
    }
}
