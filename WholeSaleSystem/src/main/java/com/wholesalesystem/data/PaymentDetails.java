package com.wholesalesystem.data;

public class PaymentDetails {
    private int buyer_id;
    private String buyer_name;
    private double phone_no;
    private double saleprice;
    private String order_status;
    private String payment_status;

    public PaymentDetails() {
    }

    public PaymentDetails(int buyer_id, String buyer_name,double phone_no, double saleprice,String order_status, String payment_status) {
        this.buyer_id = buyer_id;
        this.buyer_name = buyer_name;
        this.phone_no = phone_no;
        this.saleprice = saleprice;
        this.order_status = order_status;
        this.payment_status = payment_status;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public double getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(double phone_no) {
        this.phone_no = phone_no;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
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

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "buyer_id=" + buyer_id +
                ", buyer_name='" + buyer_name + '\'' +
                ", buyer_phone_no='" + phone_no + '\'' +
                ", saleprice=" + saleprice +
                ", order_status=" + order_status +
                ", payment_status='" + payment_status + '\'' +
                '}';
    }
}
