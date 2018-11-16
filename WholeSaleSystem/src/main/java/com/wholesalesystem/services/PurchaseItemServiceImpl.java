package com.wholesalesystem.services;

import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.PurchaseItems;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseItemServiceImpl implements PurchaseItemService {

    public PurchaseItemServiceImpl() {
    }

    @Override
    public PurchaseItems get(int purchase_id) {
        PurchaseItems pi = new PurchaseItems();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM PURCHASEITEM WHERE PI_PURCHASE_ID = ?");
            stmt.setInt(1, purchase_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pi.setPi_purchase_id(rs.getInt("PI_PURCHASE_ID"));
                pi.setPi_product_id(rs.getInt("PI_PRODUCT_ID"));
                pi.setPi_quantity(rs.getDouble("PI_QUANTITY"));
                pi.setPi_unit_price(rs.getDouble("PI_UNIT_PRICE"));
                pi.setPi_total_price(rs.getDouble("ITEM_TOTAL_PRICE"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pi;
    }

    @Override
    public List<PurchaseItems> listAllPurchaseItems() {
        List<PurchaseItems> listPurchaseItems = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PURCHASEITEM");
            while (rs.next()) {
                PurchaseItems pi = new PurchaseItems();
                pi.setPi_purchase_id(rs.getInt("PI_PURCHASE_ID"));
                pi.setPi_product_id(rs.getInt("PI_PRODUCT_ID"));
                pi.setPi_quantity(rs.getDouble("PI_QUANTITY"));
                pi.setPi_unit_price(rs.getDouble("PI_UNIT_PRICE"));
                pi.setPi_total_price(rs.getDouble("ITEM_TOTAL_PRICE"));
                listPurchaseItems.add(pi);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPurchaseItems;
    }

    @Override
    public void addItem(int pi_purchase_id, int pi_product_id, double pi_quantity, double pi_unit_price) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO PURCHASEITEM(PI_PURCHASE_ID,PI_PRODUCT_ID,PI_QUANTITY,PI_UNIT_PRICE,PI_PURCHITEM_ID) VALUES(?,?,?,?,?)");
            stmt.setInt(1, pi_purchase_id);
            stmt.setInt(2, pi_product_id);
            stmt.setDouble(3, pi_quantity);
            stmt.setDouble(4, pi_unit_price);
            stmt.setString(5, null);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int purchase_id, int product_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM PURCHASEITEM WHERE PI_PURCHASE_ID=? AND PI_PRODUCT_ID=?");
            stmt.setInt(1, purchase_id);
            stmt.setInt(2, product_id);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
