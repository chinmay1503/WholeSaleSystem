package com.wholesalesystem.services;

import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.Inventory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public Inventory get(int inv_product_id) {
        Inventory inventory = new Inventory();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM INVENTORY WHERE INV_PRODUCT_ID = ?");
            stmt.setInt(1, inv_product_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                inventory.setInv_product_id(rs.getInt("INV_PRODUCT_ID"));
                inventory.setProduct_quantity(rs.getDouble("PRODUCT_QUANTITY"));
                inventory.setMin_stock_level(rs.getDouble("MIN_STOCK_LEVEL"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventory;
    }

    @Override
    public List<Inventory> listAllProducts() {
        List<Inventory> listProduct = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM INVENTORY");
            while (rs.next()) {
                Inventory inventory = new Inventory();
                inventory.setInv_product_id(rs.getInt("INV_PRODUCT_ID"));
                inventory.setProduct_quantity(rs.getDouble("PRODUCT_QUANTITY"));
                inventory.setMin_stock_level(rs.getDouble("MIN_STOCK_LEVEL"));
                listProduct.add(inventory);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }

    @Override
    public void addInv(int inv_product_id, double product_quantity, double min_stock_level) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO INVENTORY VALUES(?,?,?)");
            //   stmt.setInt(1,buyer_id);
            stmt.setInt(1, inv_product_id);
            stmt.setDouble(2, product_quantity);
            stmt.setDouble(3, min_stock_level);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInv(int inv_product_id, double min_stock_level) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE INVENTORY SET MIN_STOCK_LEVEL = ? WHERE INV_PRODUCT_ID=?");
            stmt.setDouble(1, min_stock_level);
            stmt.setInt(2, inv_product_id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInv(int inv_product_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM INVENTORY WHERE INV_PRODUCT_ID=?");
            stmt.setInt(1, inv_product_id);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
