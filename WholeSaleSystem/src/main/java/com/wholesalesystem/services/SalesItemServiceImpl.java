package com.wholesalesystem.services;

import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.SalesItems;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesItemServiceImpl implements SalesItemService {
    @Override
    public SalesItems get(int order_id) {
        SalesItems salesItems = new SalesItems();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM SALESITEM WHERE SI_ORDER_ID = ?");
            stmt.setInt(1, order_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                salesItems.setSi_order_id(rs.getInt("SI_ORDER_ID"));
                salesItems.setSi_product_id(rs.getInt("SI_PRODUCT_ID"));
                salesItems.setSi_quantity(rs.getDouble("SI_QUANTITY"));
                salesItems.setSi_unit_price(rs.getDouble("SI_UNIT_PRICE"));
                salesItems.setSi_total_price(rs.getDouble("ITEM_TOTAL_PRICE"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesItems;
    }

    @Override
    public List<SalesItems> listAllSalesItems() {
        List<SalesItems> listSalesItems = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SALESITEM");
            while (rs.next()) {
                SalesItems salesItems = new SalesItems();
                salesItems.setSi_order_id(rs.getInt("SI_ORDER_ID"));
                salesItems.setSi_product_id(rs.getInt("SI_PRODUCT_ID"));
                salesItems.setSi_quantity(rs.getDouble("SI_QUANTITY"));
                salesItems.setSi_unit_price(rs.getDouble("SI_UNIT_PRICE"));
                salesItems.setSi_total_price(rs.getDouble("ITEM_TOTAL_PRICE"));
                listSalesItems.add(salesItems);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSalesItems;

    }

    @Override
    public void addItem(int si_order_id, int si_product_id, double si_quantity, double si_unit_price, double si_discounted_price) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO SALESITEM(SI_ORDER_ID,SI_PRODUCT_ID,SI_QUANTITY,SI_UNIT_PRICE,SI_DISCOUNTED_PRICE) VALUES(?,?,?,?,?)");
            stmt.setInt(1, si_order_id);
            stmt.setInt(2, si_product_id);
            stmt.setDouble(3, si_quantity);
            stmt.setDouble(4, si_unit_price);
            stmt.setDouble(5, si_discounted_price);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteItem(int order_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM SALESITEM WHERE SI_ORDER_ID=?");
            stmt.setInt(1, order_id);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Trying To Call Procedure
    public static void callProcedure(int si_product_id) {
        Connection con = null;
        CallableStatement cs = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            cs = con.prepareCall("{call UNIT_PRICE_BASED_ON_MARGIN(?)}");
            cs.setInt(1, si_product_id);
            cs.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}