package com.wholesalesystem.data;

public class Suppliers {
    private int supplier_id;
    private String supplier_name;
    private String supplier_phone_no;

    public Suppliers() {
    }

    public Suppliers(int supplier_id, String supplier_name , String supplier_phone_no) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_phone_no() {
        return supplier_phone_no;
    }

    public void setSupplier_phone_no(String supplier_phone_no) {
        this.supplier_phone_no = supplier_phone_no;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "supplier_id=" + supplier_id +
                ", supplier_name='" + supplier_name +
                "supplier_phone_no=" + supplier_phone_no + '\'' +
                '}';
    }
}
