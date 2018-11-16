package com.wholesalesystem.services;

import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.PurchaseOrders;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Override
    public List<PurchaseOrders> listAllPurchaseOrders() {
        List<PurchaseOrders> listpurchaseOrder = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PURCHASEORDERS");
            while (rs.next()) {
                PurchaseOrders po = new PurchaseOrders();
                po.setPurchaseord_id(rs.getInt("PURCHASEORD_ID"));
                po.setPo_supplier_id(rs.getInt("PO_SUPPLIER_ID"));
                po.setPurchprice(rs.getDouble("PURCHPRICE"));
                po.setPurchdate(rs.getDate("PURCHDATE"));
                po.setExp_deliverydate(rs.getDate("EXPECTED_DELIVERYDATE"));
                listpurchaseOrder.add(po);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listpurchaseOrder;
    }

    @Override
    public PurchaseOrders addPurchaseOrder(int po_supplier_id, LocalDate exp_deliverydate) {
        Connection con = null;
        java.time.LocalDate purchdate = LocalDate.now();
        java.sql.Date purchaseDate = java.sql.Date.valueOf(purchdate);
        java.sql.Date expdeldate = java.sql.Date.valueOf(exp_deliverydate);
        PurchaseOrders purchaseOrder = new PurchaseOrders();
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO PURCHASEORDERS VALUES(?,?,?,?,?)");
            stmt.setString(1, null);
            stmt.setInt(2, po_supplier_id);
            stmt.setInt(3, 0);
            stmt.setDate(4, purchaseDate);
            stmt.setDate(5, expdeldate);
            stmt.executeQuery();
            stmt.close();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PURCHASEORDERS WHERE PURCHASEORD_ID = (SELECT MAX(PURCHASEORD_ID) FROM PURCHASEORDERS)");
            while (rs.next()) {
                purchaseOrder.setPurchaseord_id(rs.getInt("PURCHASEORD_ID"));
                purchaseOrder.setPo_supplier_id(rs.getInt("PO_SUPPLIER_ID"));
                purchaseOrder.setPurchprice(rs.getDouble("PURCHPRICE"));
                purchaseOrder.setPurchdate(rs.getDate("PURCHDATE"));
                purchaseOrder.setExp_deliverydate(rs.getDate("EXPECTED_DELIVERYDATE"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchaseOrder;
    }

    @Override
    public PurchaseOrders get() {
        PurchaseOrders purchaseOrder = new PurchaseOrders();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PURCHASEORDERS WHERE PURCHASEORD_ID = (SELECT MAX(PURCHASEORD_ID) FROM PURCHASEORDERS)");
            while (rs.next()) {
                purchaseOrder.setPurchaseord_id(rs.getInt("PURCHASEORD_ID"));
                purchaseOrder.setPo_supplier_id(rs.getInt("PO_SUPPLIER_ID"));
                purchaseOrder.setPurchprice(rs.getDouble("PURCHPRICE"));
                purchaseOrder.setPurchdate(rs.getDate("PURCHDATE"));
                purchaseOrder.setExp_deliverydate(rs.getDate("EXPECTED_DELIVERYDATE"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchaseOrder;
    }

    @Override
    public void updatePurchOrderDeliveryDate(int purchaseord_id, LocalDate exp_deliverydate) {
        Connection con = null;
        java.sql.Date expdeldate = java.sql.Date.valueOf(exp_deliverydate);
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE PURCHASEORDERS SET EXPECTED_DELIVERYDATE=? WHERE PURCHASEORD_ID=?");
            stmt.setDate(1, expdeldate);
            stmt.setInt(2, purchaseord_id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePurchaseOrder(int purchaseord_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM PURCHASEORDERS WHERE PURCHASEORD_ID=?");
            stmt.setInt(1, purchaseord_id);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PurchaseOrders authenticateOrder(int purchaseord_id) {
        PurchaseOrders purchaseOrder = new PurchaseOrders();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM PURCHASEORDERS WHERE PURCHASEORD_ID = ?");
            stmt.setInt(1, purchaseord_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                purchaseOrder.setPurchaseord_id(rs.getInt("PURCHASEORD_ID"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchaseOrder;
    }
}
