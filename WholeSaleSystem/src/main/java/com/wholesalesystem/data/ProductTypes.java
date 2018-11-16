package com.wholesalesystem.data;

public class ProductTypes {
    private int pt_product_id;
    private String product_type;
    private double margin_per;

    public ProductTypes() {
    }

    public ProductTypes(int pt_product_id, String product_type, int margin_per) {
        this.pt_product_id = pt_product_id;
        this.product_type = product_type;
        this.margin_per = margin_per;
    }

    public int getPt_product_id() {
        return pt_product_id;
    }

    public void setPt_product_id(int pt_product_id) {
        this.pt_product_id = pt_product_id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public double getMargin_per() {
        return margin_per;
    }

    public void setMargin_per(double margin_per) {
        this.margin_per = margin_per;
    }

    @Override
    public String toString() {
        return "ProductTypes{" +
                "pt_product_id=" + pt_product_id +
                ", product_type='" + product_type + '\'' +
                ", margin_per=" + margin_per +
                '}';
    }
}
