package com.wholesalesystem.data;

public class Buyers {
    private int buyer_id;
    private String buyer_name;
    private String buyer_address;
    private String buyer_phone_no;
    private String buyer_email_id;

    public Buyers(){
        super();
    }

    public Buyers(int buyer_id ,String buyer_name, String buyer_address, String buyer_phone_no, String buyer_email_id) {
        super();
        this.buyer_id = buyer_id;
        this.buyer_name = buyer_name;
        this.buyer_address = buyer_address;
        this.buyer_phone_no = buyer_phone_no;
        this.buyer_email_id = buyer_email_id;
    }

    public int getBuyerId() {
        return buyer_id;
    }

    public void setBuyerId(int buyer_id) {
        this.buyer_id = buyer_id;
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

    public String getBuyer_email_id() {
        return buyer_email_id;
    }

    public void setBuyer_email_id(String buyer_email_id) {
        this.buyer_email_id = buyer_email_id;
    }

    public String toString(){
        return this.buyer_id+" "+this.buyer_name+" "+this.buyer_address+" "+this.buyer_phone_no+" "+this.buyer_email_id;
    }
}
