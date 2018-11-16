package com.wholesalesystem.data;

import java.util.Date;

public class PurchaseOrders {
    private int purchaseord_id;
    private int po_supplier_id;
    private double purchprice;
    private Date purchdate;
    private Date exp_deliverydate;

    public PurchaseOrders() {
    }

    public PurchaseOrders(int purchaseord_id, int po_supplier_id, double purchprice, Date purchdate, Date exp_deliverydate) {
        this.purchaseord_id = purchaseord_id;
        this.po_supplier_id = po_supplier_id;
        this.purchprice = purchprice;
        this.purchdate = purchdate;
        this.exp_deliverydate = exp_deliverydate;
    }

    public int getPurchaseord_id() {
        return purchaseord_id;
    }

    public void setPurchaseord_id(int purchaseord_id) {
        this.purchaseord_id = purchaseord_id;
    }

    public int getPo_supplier_id() {
        return po_supplier_id;
    }

    public void setPo_supplier_id(int po_supplier_id) {
        this.po_supplier_id = po_supplier_id;
    }

    public double getPurchprice() {
        return purchprice;
    }

    public void setPurchprice(double purchprice) {
        this.purchprice = purchprice;
    }

    public Date getPurchdate() {
        return purchdate;
    }

    public void setPurchdate(Date purchdate) {
        this.purchdate = purchdate;
    }

    public Date getExp_deliverydate() {
        return exp_deliverydate;
    }

    public void setExp_deliverydate(Date exp_deliverydate) {
        this.exp_deliverydate = exp_deliverydate;
    }

    @Override
    public String toString() {
        return "PurchaseOrders{" +
                "purchaseord_id=" + purchaseord_id +
                ", po_supplier_id=" + po_supplier_id +
                ", purchprice=" + purchprice +
                ", purchdate=" + purchdate +
                ", exp_deliverydate=" + exp_deliverydate +
                '}';
    }

}
